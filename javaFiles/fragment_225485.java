String url = "http://www.theGateWayurl.com";
// Generates the connection to the amf gateway.
AMFConnection amfConnection = new AMFConnection();

// Must register the class that this library will use to load the
// AMF object information.
// The library will read AMF object variables and use setters from
// the java bean stated in this line.
AMFConnection.registerAlias("", new LabelData().getClass().getName());

try {
    // Do the connection.
    amfConnection.connect(url);

    // This page requires a certain headers to function.
    // The Content-type is used to sniff with Charles Web Proxy.
    amfConnection.addHttpRequestHeader("Content-type", "application/x-amf");
    // The Referer is used by the webpage to allow gathering information.
    amfConnection.addHttpRequestHeader("Referer", "http://orlandoinfo.com/ws/b2c/sitesearch/customtags/comSearch.swf");

    // The rest of the HTTP POST sent by this library is wrapped
    // inside a RemotingMessage.
    // Prepare the msg to send.
    RemotingMessage msg = new RemotingMessage();

    // The method called in the server.
    msg.setOperation("getLocations");

    // Where the request came from. Similar to referer.
    msg.setSource("ws.b2c.sitesearch.components.myService");

    // The destination is a needed parameter.
    msg.setDestination("ColdFusion");

    // Create the body with the parameters needed to call the
    // operation set with setOperation()
    msg.setBody(new Object[] {"consumer", "attractions"});

    // This is needed but not used.
    msg.setMessageId("xxxxxxxxxx");

    // Send the msg.
    AcknowledgeMessage reply = (AcknowledgeMessage) amfConnection.call("null", msg);

    // Parse the reply from the server.
    ArrayCollection body = (ArrayCollection) reply.getBody();
    for (Object obj : body) {
        LabelData location = (LabelData) obj;
        // Do something with the info.
    }

} catch (ClientStatusException cse) {
    // Do something with the exception.

} catch (ServerStatusException sse) {
    // Do something with the exception.
} finally {
    amfConnection.close();
}