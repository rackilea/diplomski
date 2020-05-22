WSSecUsernameToken builder = new WSSecUsernameToken();
builder.setPasswordType(WSConstants.PASSWORD_TEXT);
// set user name an password
builder.setUserInfo("wernerd", "verySecret");
// create a sample soap message
Document doc = SOAPUtil.toSOAPPart(SOAPUtil.SAMPLE_SOAP_MSG);
WSSecHeader secHeader = new WSSecHeader(doc);
secHeader.insertSecurityHeader();
// create the soap message with WSS headers
Document signedDoc = builder.build(doc, secHeader);
// simply print the result
System.out.println(XMLUtils.prettyDocumentToString(signedDoc));