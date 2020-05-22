class Weather {
   public final static Weather RAINY = new Weather( );
   public final static Weather Sunny = new Weather( );

   static int count = 0;

   Weather( ) {
     System.out.print("c ");
     incr();
   }

   static void incr()
   {
      count++;
   }
 }