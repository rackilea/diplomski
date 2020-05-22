public Node buildSecurityHeader(String username, String password) 
        throws WSSecurityException, ParserConfigurationException, SAXException, IOException{

    //XML Document builder with a root node
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputSource inStream = new InputSource();
    inStream.setCharacterStream(new StringReader("<root></root>"));
    Document document = builder.parse(inStream);

    //<wsse:UsernameToken>
    WSSecUsernameToken usernametoken = new WSSecUsernameToken();
    usernametoken.setPasswordType(WSConstants.PASSWORD_DIGEST);
    usernametoken.setUserInfo(username, password);

    //<wsse:Security>
    WSSecHeader secHeader = new WSSecHeader(document);
    secHeader.insertSecurityHeader();

    //Generates the Document with <root><Header><wsse:Security>...
    usernametoken.build(document, secHeader);

    //Extract the desired node
    Node securityNode = document.getElementsByTagName("wsse:Security").item(0);

    return securityNode;

}