@Designate( ocd= Species.Config.class, factory=true )
 @Component( name = "species.pid", configurationPolicy=ConfigurationPolicy.REQUIRE )
 public class Species {
      @ObjectClassDefinition
      @interface Config {
          String id();
      }

      @Activate
      void activate( Config config) {
          System.out.println( config.id() );
      }
}