// get the schemas used by this class
        final Map<String, String> schemas = new HashMap<String,String>();
        schemas.putAll(generateSchemas(jc));

        List<StreamSource> sources = new ArrayList<StreamSource>();
        for( String schema : schemas.values() )
            sources.add( new StreamSource( new ByteArrayInputStream(schema.getBytes())));

        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        sf.setResourceResolver(new LSResourceResolver() {
            @Override
            public LSInput resolveResource(String type, final String namespaceURI, String publicId, String systemId, String baseURI){
                logger.debug( "Need to resolve Resource: " + namespaceURI );
                return new LSInput(){
                    @Override
                    public String getStringData() {
                        // return the schema if found
                        if( schemas.containsKey(namespaceURI)){
                            if( logger.isTraceEnabled())
                                logger.trace("resourceResolver: Resolving schema for namespace: " + namespaceURI + schemas.get(namespaceURI) );
                            return schemas.get(namespaceURI);
                        }
                        else
                            return null;
                    }
                    @Override
                    public Reader getCharacterStream() {
                        return null;
                    }
                    @Override
                    public void setCharacterStream(Reader paramReader) {
                    }
                    @Override
                    public InputStream getByteStream() {
                        return null;
                    }
                    @Override
                    public void setByteStream(InputStream paramInputStream) {
                    }
                    @Override
                    public void setStringData(String paramString) {
                    }
                    @Override
                    public String getSystemId() {
                        return null;
                    }
                    @Override
                    public void setSystemId(String paramString) {
                    }
                    @Override
                    public String getPublicId() {
                        return null;
                    }
                    @Override
                    public void setPublicId(String paramString) {
                    }
                    @Override
                    public String getBaseURI() {
                        return null;
                    }
                    @Override
                    public void setBaseURI(String paramString) {
                    }
                    @Override
                    public String getEncoding() {
                        return null;
                    }
                    @Override
                    public void setEncoding(String paramString) {
                    }
                    @Override
                    public boolean getCertifiedText() {
                        return false;
                    }
                    @Override
                    public void setCertifiedText(boolean paramBoolean) {
                    }
                };
            }
        });

        // validate the schema
        u.setSchema(sf.newSchema(sources.toArray(new StreamSource[]{})));