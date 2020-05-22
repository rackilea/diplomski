package com.nishu.ld28.utilities;

import java.io.InputStream;

public class MyClass {

   public static void main(String[] args) {
      InputStream is = MyClass.class.getResourceAsStream("sound/merry_xmas.wav");

      System.out.format("is is null ? => %s", is==null);
   }
}