String example = new String(Files.readAllBytes(Paths.get("input.xml")), StandardCharsets.UTF_8);
SOAPMessage message = MessageFactory.newInstance().createMessage(null,
        new ByteArrayInputStream(example.getBytes()));

Document doc = message.getSOAPBody().extractContentAsDocument();

Element root = doc.getDocumentElement();