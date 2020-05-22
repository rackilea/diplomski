SOAPMessage soap = MessageFactory.newInstance().createMessage();

SOAPEnvelope envelope = soap.getSOAPPart().getEnvelope();
envelope.addAttribute(new QName("xmlns:s"), "http://schemas.xmlsoap.org/soap/envelope/");
envelope.addAttribute(new QName("xmlns:a"), "http://www.w3.org/2005/08/addressing");




SOAPHeader header = soap.getSOAPHeader();
header.addAttribute(new QName("xmlns:xsd"), "http://www.w3.org/2001/XMLSchema");
header.addAttribute(new QName("xmlns:xsi"), "http://www.w3.org/2001/XMLSchema-instance");

SOAPElement actionElement = header.addChildElement("a:Action");
actionElement.addAttribute(new QName("s:mustUnderstand"), "1");
actionElement.addTextNode("http://www.w3.org/2009/02/ws-tra/Create");

SOAPElement channelIdentifierElement = header.addChildElement("h:ChannelIdentifier");
channelIdentifierElement.addAttribute(new QName("xmlns:h"), "http://my-web-site.org/my-trans/identifiers/1.0/");
channelIdentifierElement.addAttribute(new QName("xmlns"), "http://my-web-site.org/my-trans/identifiers/1.0/");
channelIdentifierElement.addTextNode("4");

SOAPElement documentIdentifierElement = header.addChildElement("h:DocumentIdentifier");
documentIdentifierElement.addAttribute(new QName("xmlns:h"), "http://my-web-site.org/my-trans/identifiers/1.0/");
documentIdentifierElement.addAttribute(new QName("xmlns"), "http://my-web-site.org/my-trans/identifiers/1.0/");
documentIdentifierElement.addAttribute(new QName("xmlns:xsd"), "http://www.w3.org/2001/XMLSchema");
documentIdentifierElement.addAttribute(new QName("xmlns:xsi"), "http://www.w3.org/2001/XMLSchema-instance");
documentIdentifierElement.addAttribute(new QName("scheme"), "");
documentIdentifierElement.addTextNode("XXXXXX");

SOAPElement messageIdentifierElement = header.addChildElement("h:MessageIdentifier");
messageIdentifierElement.addAttribute(new QName("xmlns:h"), "http://my-web-site.org/my-trans/identifiers/1.0/");
messageIdentifierElement.addAttribute(new QName("xmlns"), "http://my-web-site.org/my-trans/identifiers/1.0/");
messageIdentifierElement.addTextNode("d8c314a3-6add-474c-871a-e0872612beeb");

SOAPElement messageIdElement = header.addChildElement("a:MessageID");
messageIdElement.addTextNode("urn:uuid:856e3d41-92ef-4332-8a36-82d98b436fb4");

SOAPElement replyToElement = header.addChildElement("a:ReplyTo");
SOAPElement addressElement = replyToElement.addChildElement("a:Address");
addressElement.addTextNode("http://www.w3.org/2005/08/addressing/anonymous");

SOAPElement aToElement = header.addChildElement("a:To");
aToElement.addAttribute(new QName("s:mustUnderstand"), "1");
aToElement.addTextNode("https://XXX.com/AP1/ResourceService.svc");




SOAPBody body = soap.getSOAPBody();
body.addAttribute(new QName("xmlns:xsd"), "http://www.w3.org/2001/XMLSchema");
body.addAttribute(new QName("xmlns:xsi"), "http://www.w3.org/2001/XMLSchema-instance");

SOAPElement createElement = body.addChildElement("Create");
createElement.addAttribute(new QName("xmlns"), "http://www.w3.org/2009/02/ws-tra");
SOAPElement messageElement = createElement.addChildElement("message");
messageElement.addAttribute(new QName("xmlns"), "");
messageElement.addTextNode("&lt;AccessPoint.BO.Document&gt;&lt;![CDATA[Dummy Content]]&gt;&lt;/AccessPoint.BO.Document&gt;");




ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
soap.writeTo(outputStream);
System.out.println(new String(outputStream.toByteArray()));