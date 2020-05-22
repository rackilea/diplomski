@ApplicationPath( "api" )
public class MyRestApplication extends Application
{
   @Override
   public Set<Class<?>> getClasses( )
   {
       Set<Class<?>> resources = new HashSet<Class<?>>( );
       resources.add( ApiListingResource.class );
       resources.add( ApiDeclarationProvider.class );
       resources.add( ApiListingResourceJSON.class );
       resources.add( ResourceListingProvider.class );
       resources.add( Ping.class ); // my own resource class
       swaggerConfiguration( );
       return resources;
   }

   private void swaggerConfiguration( )
   {
      SwaggerConfig swaggerConfig = new SwaggerConfig( );
      ConfigFactory.setConfig( swaggerConfig );
      swaggerConfig.setApiVersion( "0.0.1" ); 
      swaggerConfig.setBasePath( "http://localhost:8080/MyService/api" );
      ScannerFactory.setScanner( new DefaultJaxrsScanner( ) );
      ClassReaders.setReader( new DefaultJaxrsApiReader( ) );
   }
}