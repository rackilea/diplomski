HttpResponse httpResponse = null;
String username = "";
String password = "";
String url = "";
String postBody = "";

try {
    httpResponse = WS.url(url)
        .authenticate(username, password)
        .setHeader("Content-Type", "text/xml; charset=UTF-8")
        .setHeader("SOAPAction", "")
        .body(postBody).post();

    Document document = httpResponse.getXml();
    String value = XPath.selectText("//value", document);
    Node node = XPath.selectNode("//node", document);

    // Do things with the nodes, value and so on

} catch (Exception e) {
    Logger.error("Do something with the connection error: %s", e);
}