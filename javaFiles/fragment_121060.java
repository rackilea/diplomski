OMFactory omFactory = OMAbstractFactory.getOMFactory();
OMElement omSecurityElement = omFactory.createOMElement(new QName( "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security", "wsse"), null);


OMElement omusertoken = omFactory.createOMElement(new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "UsernameToken", "wsu"), null);

OMElement omuserName = omFactory.createOMElement(new QName("", "Username", "wsse"), null);
omuserName.setText("myusername");

OMElement omPassword = omFactory.createOMElement(new QName("", "Password", "wsse"), null);
omPassword.addAttribute("Type","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText",null );
omPassword.setText("mypassword");

omusertoken.addChild(omuserName);
omusertoken.addChild(omPassword);
omSecurityElement.addChild(omusertoken);
stub._getServiceClient().addHeader(omSecurityElement);