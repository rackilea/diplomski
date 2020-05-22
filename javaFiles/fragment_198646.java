import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

class Ideone
{
    public static final Pattern pattern = Pattern.compile("[\\s#.$*@+]*"); // < -- Fixed pattern

    public static void main (String[] args) throws java.lang.Exception
    {
        String s = " #####\n#   ####\n#      #\n### **# #\n#  #* *@#\n#   * ###\n#  ##  #\n##     #\n#.$#  #\n#  ####\n ####";
        if (isLineValid(s)) {
            System.out.println("Valid"); 
        } else {
            System.out.println("Not Valid"); 
        }
    }

    private static boolean isLineValid(String line) {
       if (pattern.matcher(line).matches()) {
          return true;                            // <-- Returning TRUE here
       }
       return false;
    }
}