Node node = ...
    StringWriter output = new StringWriter();

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(new DOMSource(node), new StreamResult(output));

    String xml = output.toString();