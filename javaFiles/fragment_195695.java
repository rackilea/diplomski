public class Runa {

   private static Runa singleton = new Runa( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private Runa() { }

   /* Static 'instance' method */
   public static Runa getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
   protected static void demoMethod( ) {
      System.out.println("demoMethod for singleton");
   }
}