import java.io.*;
  import java.util.*;
  public final class pgm
  {
     static int x,v;
     static void func()
     {
      System.out.println("Function run");
     }
   }

  class egs
  {
   public static void main(String args[])
   {
     pgm p=null;         //ref here 
      p.func();          // use ppm func here 
      try
      {
        p.x=10;
        p.func();
      }
      catch(NullPointerException e)
     {
        System.out.println("Null caught");
     }

  }
}