SOAPMessage soapMsg = soapMessageCtx.getMessage();
NodeList credentials = soapMsg
                        .getSOAPBody()
                        .getElementsByTagNameNS("http://rsi.chase.com/model", "Credential");

int len = credentials.length();
for(int i = 0; i < len; i++) { 
    credentials.item(i).setTextContent("new credential content goes here...");
}

ByteArrayOutputStream out = new ByteArrayOutputStream();
soapMsg.writeTo(out);

// ...