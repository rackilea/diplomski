import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{ 
    public static class Coordinate {
       private int x = 3;
       private int y = 5;

       @Override
       public String toString(){
          String Strx = Integer.toString(x);
          String Stry = Integer.toString(y);
          String result = "(" + Strx + ", " + Stry + ")";
          return result;
       }
   }

    public static void main (String[] args) throws java.lang.Exception
    {
        Coordinate place = new Coordinate();
        System.out.println(place);
    }
}