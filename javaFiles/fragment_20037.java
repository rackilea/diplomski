private String getAuthentificationString() {
    String authentificationString = "Basic ";
    String fastbillUsernameAndApiKey = null;
    XmlParser getFromXml = new XmlParser();
    fastbillUsernameAndApiKey = getFromXml.getApiEmailFromConfigFile() + ":" + getFromXml.getApiKeyFromConfigFile();
    //if email and apikey are not stored in config.xml you need following string containing the emailadress and ApiKey seperated with ':'
    //f.ex. fastbillUsernameAndApiKey = "*****@****.***:*********";
    authentificationString = authentificationString + base64Encoder(fastbillUsernameAndApiKey);   
    return authentificationString;
}

private String base64Encoder(String input) {
    String result = null;
    byte[] encodedBytes = Base64.encodeBase64(input.getBytes());
    result = new String(encodedBytes);
    return result;
}