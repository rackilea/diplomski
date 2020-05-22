public static Map<String, List<String>> parseXml(String xml) throws XMLStreamException {
    StringBuilder content = null;
    Map<String, List<String>> dataMap = new HashMap<>();
    XMLInputFactory factory = XMLInputFactory.newInstance();
    InputStream stream = new ByteArrayInputStream(xml.getBytes());
    XMLStreamReader reader = factory.createXMLStreamReader(stream);

    while (reader.hasNext()) {
        int event = reader.next();

        switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                content = new StringBuilder();
                break;

            case XMLStreamConstants.CHARACTERS:
                if (content != null) {
                    content.append(reader.getText().trim());
                }
                break;

            case XMLStreamConstants.END_ELEMENT:
                if (content != null) {
                    String leafText = content.toString();
                    if(dataMap.get(reader.getLocalName()) == null){
                        List<String> values = new ArrayList<>();
                        values.add(leafText);
                        dataMap.put(reader.getLocalName(), values);
                    } else {
                        dataMap.get(reader.getLocalName()).add(leafText);
                    }
                }
                content = null;
                break;

            case XMLStreamConstants.START_DOCUMENT:
                break;
        }

    }

    return dataMap;
}