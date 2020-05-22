package com.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    static void swap(char ar[], int i, int j) 
    {  
     char temp = ar[i];
     ar[i] = ar[j];
     ar[j] = temp;
    }
    public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);
      //int num = in .nextInt();
      char[] chars=null;
      String numStr=in.next();
      int num= Integer.valueOf(numStr);
      if(numStr.startsWith("0")) {
          chars= ("0" + num).toCharArray();
      }else {
          chars= ("" + num).toCharArray();
      }

      int i;
      int n = chars.length;
      for (i = n - 1; i > 0; i--)
      {
       if (chars[i] > chars[i - 1]) 
        break;
      }
      if (i == 0) 
       System.out.println(num);
      else {
       int x = chars[i - 1], min = i;
      for (int j = i + 1; j<n; j++)
      {
       if (chars[j] > x && chars[j]<chars[min])
        min = j;
      }
      swap(chars, i - 1, min);
      Arrays.sort(chars, i, n);
      for (i = 0; i<n; i++)
        System.out.print(chars[i]);
     }
    }
}