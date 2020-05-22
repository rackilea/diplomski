public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            if (systemId.contains(my1Dtd)) {
                return new InputSource(MyClass.class.getResourceAsStream(MY1_DTD_RESOURCE_PATH));
            } else if (systemId.contains(my2Dtd)) {
                return new InputSource(MyClass.class.getResourceAsStream(MY2_DTD_RESOURCE_PATH));
            } else {
                return null;
            }
        }