private Map<String, String> generateSchemas (JAXBContext jaxbContext) throws JAXBException{
    // generate the schemas
    final Map<String, ByteArrayOutputStream> schemaStreams = new LinkedHashMap<String,ByteArrayOutputStream>();

    try {
        jaxbContext.generateSchema(new SchemaOutputResolver(){
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                logger.debug( "GenerateSchemas: adding namespace: " + namespaceUri);
                schemaStreams.put(namespaceUri, out);
                StreamResult streamResult = new StreamResult(out);
                streamResult.setSystemId("");
                return streamResult;
            }});
    } catch (IOException e) {
        // no IO being performed.  Can safely ignore any IO exception.
    }

    // convert to a list of string
    Map<String,String> schemas = new LinkedHashMap<String,String>();
    for( Map.Entry<String, ByteArrayOutputStream> entry : schemaStreams.entrySet() ){
        String schema = entry.getValue().toString();
        String namespace = entry.getKey();
        schemas.put(namespace, schema);
    }

    // done
    return schemas;
}