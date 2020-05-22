int highestHits = 0;
    String currentResult = null;
    while (reader.hasNext()) {
        int event = reader.next();
        if (event == XMLStreamConstants.START_ELEMENT && reader.getLocalName().equals("output")) {
            int currentHits = Integer.parseInt(reader.getAttributeValue(0));
            if (currentHits > highestHits) {
                highestHits = currentHits;
                reader.next();
                currentResult = reader.getText();
            }
        }
    }