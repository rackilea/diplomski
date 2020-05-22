String s = assertionOMElement.toString();
DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
documentBuilderFactory.setNamespaceAware(true);
DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
Document document = docBuilder.parse(new ByteArrayInputStream(s.trim().getBytes()));
Element element = document.getDocumentElement();