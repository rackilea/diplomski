import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{

public static String replaceWith(String parentString, String occurrence, String replaceWith){
      String newString = "";

      for(int i = 0; i <= parentString.length()-occurrence.length(); ++i) {
        boolean add = false;
        for(int j = 0; j < occurrence.length(); ++j) {
            if(parentString.charAt(i+j) != occurrence.charAt(j)) add = true;
        }
        if(add) {
            newString += parentString.charAt(i);
        } else {
            i += occurrence.length()-1;
            newString += replaceWith;
        }
      }

      return newString;
}

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(replaceWith("I replace banana, banana and some more banana", "banana", "apple"));
    }
}