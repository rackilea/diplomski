import java.util.*;
public class Stress {

   static Runtime runtime = Runtime.getRuntime();
   static long cnt = 0;

   public static void stress_heap() {
      int size = 1024; // start with 1kb
      // research question: what happens to cnt as you modify size ?
      List<byte[]> a = new ArrayList<>(); // keep a list of byte arrays.
      System.out.println("stress_heap(): size="+size);
      try {
         while( true ) {
            byte[] b = new byte[size];
            a.add( b );
            ++cnt; // only increment if successful.
            if( 0 == (cnt % 100000) ) {
               // Question: does this output display at the same tempo?
               // Or does it get faster (or slower) as the program runs?
               System.out.println("stress_heap() cnt="+cnt+" free="+runtime.freeMemory()+" total="+runtime.totalMemory() );
            }
         }
      } catch( Exception e ) { 
         // Sometimes fails so hard it doesn't reach this catch block.
         System.out.println("stress_heap(): problem, cnt="+cnt+", exception="+e);
      }
   }

   public static void stress_stack_recurse( ) { 
      ++cnt;
      if( 0 == (cnt % 100) ) {
         // Question: why does stress_stack_recurse() fail at such a low value count compared to stress_heap() ?
         // Question: does this output display at the same tempo?
         System.out.println("stress_stack_recurse() cnt="+cnt+" free="+runtime.freeMemory()+" total="+runtime.totalMemory() );
      }
      stress_stack_recurse( );
   }

   public static void stress_stack( ) { 
      // want the 
      try {
         stress_stack_recurse( );
      } catch( Exception e ) { 
         // Sometimes fails so hard it doesn't reach this catch block.
         System.out.println("stress_stack(): problem, cnt="+cnt+", exception="+e);
      }
   }


   public static void main( String[] args ) {
      //stress_heap();
      stress_stack();
   }
}