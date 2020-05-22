...

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        // Store the current element that started now
        currentElement = qName;

        // If this is a Movie tag, save the contents because we might need it
        if (qName.equals("Movie")) {
            contents = new StringBuilder();
        }

    }
...