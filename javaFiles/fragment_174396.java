@Path("/emailnotification")
public class ExchangeNotificationListener {

private static final Log logger = LogFactory.getLog(ExchangeNotificationListener.class);
private static final String OK = "OK";
private static final String UNSUBSCRIBE = "Unsubscribe";

/**
 * This method receives a SOAP message from Microsoft Exchange Web Services, parses it into a ExchangeNotification object,
 * do some business logic and sends an ACK response to keep the subscription alive.
 * 
 * @param request
 *            EWS Push Notification request
 * @param response
 * @throws Exception
 */
@Path("/incomingevent")
@POST()
@Consumes(MediaType.TEXT_XML)
public void onNotificationReceived(@Context HttpServletRequest request, @Context HttpServletResponse response)
        throws Exception {

    // Establish the start time so we can report total elapsed time to execute the call later.
    long startTime = GregorianCalendar.getInstance().getTimeInMillis();
    long endTime;

    // Retrieve the EWS Notification message as an XML document
    Document notificationXML = loadXML(IOUtils.toString(request.getInputStream()));

    // Deserialize the document
    ExchangeNotification notif = new ExchangeNotification(notificationXML);

    // We need the subscription id in order to proceed
    String subscriptionId = notif.getSubscriptionId();

    if (isBlank(subscriptionId)) {
        logger.error("SOAP Envelope MUST contains the subscriptionId");
        // If we did not successfully parse the XML document, tell Exchange that we got a bad request.
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }

    if (!ExchangeSubscriptionMap.getInstance().getSubscriptionsMap().containsKey(subscriptionId)) {
        logger.warn("SubscriptionId = " + subscriptionId
                + " was not found in the subscriptions map. Unsubscribing...");
        sendResponse(response, UNSUBSCRIBE);
        return;
    }

    // Do some logic here depending on the current EventType
    businessLogic(notif, response);

    // Flush the buffer and report the total time taken to execute for this notification.
    response.flushBuffer();
    endTime = GregorianCalendar.getInstance().getTimeInMillis();
    logger.debug(String.format("Total execution time: %1$s (ms)", (Long) (endTime - startTime)));
}

/**
 * Sends an ACK response to the Exchange Web Service
 * 
 * @param response
 * @param msg
 *            the content of the response message
 */
private void sendResponse(HttpServletResponse response, String msg) {
    try {
        // Build the HTTP response
        String str = ExchangeUtils.getResponseXML(msg);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/xml; charset=UTF-8");
        response.setContentLength(str.length());

        // Send the response.
        PrintWriter w = response.getWriter();
        w.print(str);
        w.flush();
    } catch (IOException e) {
        logger.error("Error getting the response writer");
        Throwables.propagate(e);
    }
}

/**
 * Process the incoming notification, do some business logic and send an ACK response to Exchange
 * 
 * @param notification
 *            to be processed
 * @param response
 *            to be returned
 */
@SuppressWarnings("unchecked")
private void businessLogic(ExchangeNotification notification, HttpServletResponse response) {
    try {
        // Iterate the notification events
        for (SubscriptionEvent event : notification.getEvents()) {
            // Only take care of the Modified event
            switch (event.getEventType()) {
            case MODIFIED:
                // logic here
                // Get the ExchangeService instance this user use for Subscribing
                MSExchangeServiceManager service = ExchangeSubscriptionMap.getInstance().getSubscriptionsMap().get(notification.getSubscriptionId()).getService();

               //e.g: service.getUnreadMessages(WellKnownFolderName.Inbox));
                break;
            default:
                logger.debug("Skipping: " + event.getEventType());
                break;
            }
        }

        // Finally, send the response.
        sendResponse(response, OK);

    } catch (Exception e) {
        logger.error("EWS ==> Error processing request", e.getCause());
        Throwables.propagate(e);
    }
}

/**
 * Create a XML Document using a raw xml string
 * 
 * @param rawXML
 *            the raw xml string to be converted
 * @return XML EWS Nofitication document
 */
private Document loadXML(String rawXML) {
    Document doc = null;
    try {
        logger.debug("Incoming request input stream : " + rawXML);

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();

        // turn on this flag in order to resolve manually the namespaces of the document
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse(new InputSource(new ByteArrayInputStream(rawXML.getBytes("UTF-8"))));
    } catch (ParserConfigurationException e) {
        logger.error("Unable to create a new DocumentBuilder");
        Throwables.propagate(e);
    } catch (UnsupportedEncodingException e) {
        logger.error("Unsupported Encoding: UTF-8");
        Throwables.propagate(e);
    } catch (SAXException e) {
        logger.error("Error parsing XML");
        Throwables.propagate(e);
    } catch (IOException e) {
        logger.error("IOException");
        Throwables.propagate(e);
    }
    return doc;
  }
}