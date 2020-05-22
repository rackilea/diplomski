SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
SOAPFactory soapFactory = SOAPFactory.newInstance();

SOAPHeader sh = envelope.addHeader();
SOAPElement wsSecHeaderElm = soapFactory.createElement("Security", AUTH_PREFIX, AUTH_NS);
SOAPElement userNameTokenElm = soapFactory.createElement("UsernameToken", AUTH_PREFIX, AUTH_NS);
SOAPElement userNameElm = soapFactory.createElement("Username", AUTH_PREFIX, AUTH_NS);
SOAPElement passwdElm = soapFactory.createElement("Password", AUTH_PREFIX, AUTH_NS);

userNameElm.addTextNode("username");
passwdElm.addTextNode("password");

userNameTokenElm.addChildElement(userNameElm);
userNameTokenElm.addChildElement(passwdElm);
wsSecHeaderElm.addChildElement(userNameTokenElm);
sh.addChildElement(wsSecHeaderElm);