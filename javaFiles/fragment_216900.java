DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
domFactory.setNamespaceAware(true);
DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
Document doc = docBuilder.newDocument();
DOMResult domResult = new DOMResult(doc);
marshaller.marshal(myDataPDU, domResult);