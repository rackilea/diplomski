// Create SOAP Message
private static SOAPMessage createSOAPRequest(File uploadFile, Map<String, String> values, String fileName, String[] attributes) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Header
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", ACTION);

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("sch", NAMESPACE);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement createItemRequest = soapBody.addChildElement("CreateItemRequest", "sch");
            SOAPElement authenticationData = createItemRequest.addChildElement("AuthenticationData", "sch");
                SOAPElement serverDef = authenticationData.addChildElement("ServerDef", "sch");
                    SOAPElement serverType = serverDef.addChildElement("ServerType", "sch");
                    serverType.addTextNode("ICM");
                    SOAPElement serverName = serverDef.addChildElement("ServerName", "sch");
                    serverName.addTextNode("icmnlsdb");
                SOAPElement loginData = authenticationData.addChildElement("LoginData", "sch");
                    SOAPElement userID = loginData.addChildElement("UserID", "sch");
                    userID.addTextNode("*******");
                    SOAPElement password = loginData.addChildElement("Password", "sch");
                    password.addTextNode("*******");
            SOAPElement item = createItemRequest.addChildElement("Item", "sch");
                SOAPElement itemXML = item.addChildElement("ItemXML", "sch");
                    SOAPElement type = itemXML.addChildElement(values.get("Type"), "sch");

                    for(int i = 0; i<attributes.length;i++)
                        type.setAttribute(attributes[i],values.get(attributes[i]));

                        SOAPElement icmBASE = type.addChildElement("ICMBASE", "sch");
                            SOAPElement resourceObject = icmBASE.addChildElement("resourceObject", "sch");

                            resourceObject.setAttribute("MIMEType",Files.probeContentType(uploadFile.toPath()));

                            resourceObject.setAttribute("xmlns","http://www.ibm.com/xmlns/db2/cm/api/1.0/schema");
                                SOAPElement label = resourceObject.addChildElement("label", "sch");
                                label.setAttribute("name",fileName);

        AttachmentPart attachment = soapMessage.createAttachmentPart();

        InputStream targetStream = new FileInputStream(uploadFile);

        attachment.setRawContent(targetStream, Files.probeContentType(uploadFile.toPath()));

        attachment.setContentId(fileName);

        soapMessage.addAttachmentPart(attachment);

        soapMessage.saveChanges();

        return soapMessage;
}