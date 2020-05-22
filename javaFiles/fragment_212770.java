@Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        Log.i(TAG, "START TAG: " + localName);

        currTag = true;
        currTagVal = "";
        if (localName.equals("title"))
            post = new XDAObject();
    }