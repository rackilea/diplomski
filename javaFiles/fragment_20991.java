...
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        // Rebuild the XML if it's a node we didn't skip
        if (qName.equals("Movie")) {
            if (!skip) {
                result.add(contents.insert(0, "<Movie>").append("</Movie>").toString());
            }

            // reset the variables so we can check the next node
            contents = null;
            skip = false;
        } else if (contents != null && !skip) {
            contents.append("<").append(qName).append(">")
                    .append(currentData)
                    .append("</").append(qName).append(">");
        }

        currentElement = null;
    }
...