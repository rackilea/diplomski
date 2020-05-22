String xml = "<header:HostError>" +
     "<header:message>\n" +
     "<header:messageCode>321</header:messageCode>\n" +
     "<header:message>test</header:message>\n" +
     "</header:message>\n" +
     "<header:message>\n" +
     "<header:messageCode>123</header:messageCode>\n" +
     "<header:message>test</header:message>\n" +
     "</header:message>\n" +
     "</header:HostError>";

DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));

NodeList list = doc.getElementsByTagName("header:messageCode");

System.out.println("First messageCode : " + list.item(0).getFirstChild().getNodeValue());

NodeList list_ = doc.getElementsByTagName("header:message");
System.out.println("First message : " + list_.item(1).getFirstChild().getNodeValue());