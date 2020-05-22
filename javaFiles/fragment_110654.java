import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

      Scanner scn = new Scanner (System.in);

      int N = scn.nextInt();
      int M = scn.nextInt();

      Long [] hello = new Long [N+2];

      for (int pro = 0; pro < M ; pro++){
         int a = scn.nextInt();
         int b = scn.nextInt();
         long k = scn.nextInt();
         if (hello[a] == (Long) null) hello[a] = (long)0;
         if (hello[b+1] == (Long) null) hello [b+1] = (long)0;
         hello[a] += k;
         hello [b+1] += k * -1;

      }

    //compile the arry and find the largest
      boolean editLargest = true;
      Long largest = hello[0];
      long eK = 0;
      for (int pro = 0; pro < hello.length-1 ; pro++){
          if (hello [pro] == (Long)null)continue;
          if (editLargest){
                largest = hello[pro];
                editLargest = false;
          }
          eK += hello[pro];
          if (largest < eK) largest = eK;
      }
      System.out.println (largest);

  }
}