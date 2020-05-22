XMLStreamWriter writer = ...
         writer.setNamespaceContext(new NamespaceContext() {
            public Iterator getPrefixes(String namespaceURI) {
                return null;
            }

            public String getPrefix(String namespaceURI) {
                return "";
            }

            public String getNamespaceURI(String prefix) {
                return null;
            }
        });