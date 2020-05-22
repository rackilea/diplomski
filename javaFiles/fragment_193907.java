public class PropertiesAccessor {

   private static MyConfiguration mMyConfig = ConfigFactory.create(MyConfiguration.class);

   private PropertiesAccessor() 
      // No need to allow instantiation of this class
   }

   /**
    * Get properties for this application
    *
    * @return Properties
    */
   public static MyConfiguration getProperties() {
      return mMyConfig;
   }

   // for unit testing
   @VisibleForTesting
   public static void setProperties(MyConfiguration config) {
      mMyConfig = config;
   }
}