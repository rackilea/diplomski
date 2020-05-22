public static void main( String[] args ) {
      //stress_heap();
      //stress_stack();
      byte[] b = new byte[1024];
      stress_both( b);
   }

   public static void stress_both( byte[] b ) {
      ++cnt;
      if( 0 == (cnt % 100) ) {
         System.out.println("stress_both() cnt="+cnt+" b.length="+b.length+" free="+runtime.freeMemory()+" total="+runtime.totalMemory() );
      }
      byte[] yetAnotherByteArray = new byte[1024];
      stress_stack_recurse( yetAnotherByteArray );

   }
}