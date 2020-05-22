public class MVNLinksHolder{

public static String version = "";

public MVNLinksHolder(){
    ClassPathResource resource = new ClassPathResource( "app.properties" );
    Properties p = new Properties();
    InputStream inputStream = null;
    try {
        inputStream = resource.getInputStream();
        p.load( inputStream );
        version = p.getProperty("application.version");
    }
    catch ( IOException e ) {
        LOGGER.error( e.getMessage(), e );
    }
    finally {
        Closeables.closeQuietly( inputStream );
    }
}
}