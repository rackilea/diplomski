RootNode rootNode = new RootNode();
rootNode.text = new EncText();
rootNode.text.mediaType = "plain/text";
rootNode.text.textValue = "Data come from database.";

JAXBContext jaxbContext = JAXBContext.newInstance(RootNode.class);
Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(rootNode, System.out);