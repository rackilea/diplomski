public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

  private final org.slf4j.Logger LOG = LoggerFactory
        .getLogger("SOAPMessageLoggingHandler");

  public void close(MessageContext context) {
     }

  public boolean handleFault(SOAPMessageContext context) {
    logMessage(context, "SOAP Error is : ");
    return true;
  }

  public boolean handleMessage(SOAPMessageContext context) {
    logMessage(context, "SOAP Message is : ");
    return true;
  }

  public Set<QName> getHeaders() {
    return Collections.EMPTY_SET;
  }

  private boolean logMessage(MessageContext mc, String type) {
    try {
        if (LOG.isDebugEnabled()) {
            LOG.debug(type);
            SOAPMessage msg = ((SOAPMessageContext) mc)
                    .getMessage();

            // Print out the Mime Headers
            MimeHeaders mimeHeaders = msg.getMimeHeaders();
            Iterator mhIterator = mimeHeaders.getAllHeaders();
            MimeHeader mh;
            String header;
            LOG.debug("  Mime Headers:");
            while (mhIterator.hasNext()) {
                mh = (MimeHeader) mhIterator.next();
                header = new StringBuffer(" Name: ")
                        .append(mh.getName()).append(" Value: ")
                        .append(mh.getValue()).toString();
                LOG.debug(header);
            }

            LOG.debug(" SOAP Message: ");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            msg.writeTo(baos);
            LOG.debug("   " + baos.toString());
            baos.close();
        }

        return true;
    } catch (Exception e) {
        if (LOG.isErrorEnabled()) {
            LOG.error("Error logging SOAP message",
                    e);
        }

        return false;
    }
  }
}