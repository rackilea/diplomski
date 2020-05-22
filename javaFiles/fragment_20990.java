...
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        // if we discovered that we don't need this data, we skip it
        if (skip || currentElement == null) {
            return;
        }

        // If we are inside the tag we want to search, save the contents
        currentData = new String(ch, start, length);

        if (currentElement.equals(tagToMatch)) {
            boolean discard = true;

            if (strict) {
                if (currentData.equals(tagContents)) { // exact match
                    discard = false;
                }

            } else {
                if (currentData.toLowerCase().indexOf(tagContents.toLowerCase()) >= 0) { // matches occurrence of substring
                    discard = false;
                }
            }

            if (discard) {
                skip = true;
            }
        }

    }
...