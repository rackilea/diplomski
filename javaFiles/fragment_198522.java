class JnlpResponseCache extends ResponseCache {
    private final DownloadService service;

    private JnlpResponseCache(){
        try {
            service = (DownloadService)ServiceManager.lookup("javax.jnlp.DownloadService");
        } catch( UnavailableServiceException ex ) {
            throw new NoClassDefFoundError( ex.toString() );
        } 
    }

    static void init(){
        if( ResponseCache.getDefault() == null ){
            ResponseCache.setDefault( new JnlpResponseCache() );
        }
    }

    @Override
    public CacheResponse get( URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders ) throws IOException {
        return null;
    }

    @Override
    public CacheRequest put( URI uri, URLConnection conn ) throws IOException {
        URL url = uri.toURL();
        service.loadResource( url, null, service.getDefaultProgressWindow() );
        return null;
    }

}