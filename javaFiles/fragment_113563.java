XMLInputFactory factory = XMLInputFactory.newInstance();
factory.setXMLResolver(new XMLResolver() {
    @Override
    public Object resolveEntity(String publicID, String systemID,
            String baseURI, String namespace) throws XMLStreamException {
        //return a closed input stream if external entities are not needed
        return new InputStream() {
            @Override
            public int read() throws IOException {
                return -1;
            }
        };
    }
});

XMLEventReader reader = factory.createXMLEventReader( . . . );
try {
    while(reader.hasNext()) {
        XMLEvent event = reader.nextEvent();
        switch (event.getEventType()) {
            case XMLStreamConstants.DTD:
                List<EntityDeclaration> entities = ((DTD)event).getEntities();
                if (entities != null) {
                    for (EntityDeclaration entity : entities)
                        System.out.println(entity.getName() + " = " + entity.getSystemId());
                }
                break;
            case . . .
        }
    }
} finally {
    reader.close();
}