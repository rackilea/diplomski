Marshaller marshaller = org.opensaml.Configuration
            .getMarshallerFactory().getMarshaller(logoutRequest);
org.w3c.dom.Element authDOM = marshaller.marshall(logoutRequest);
StringWriter rspWrt = new StringWriter();
XMLHelper.writeNode(authDOM, rspWrt);
System.out.println(rspWrt.toString());