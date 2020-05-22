@Bean
    @Qualifier("idp-ssocircle")
    public ExtendedMetadataDelegate ssoCircleExtendedMetadataProvider() throws MetadataProviderException {  
        @SuppressWarnings({ "deprecation"})
        HTTPMetadataProvider httpMetadataProvider = new HTTPMetadataProvider("https://idp.ssocircle.com/idp-meta.xml", 5000);
        // other config.s...
    }