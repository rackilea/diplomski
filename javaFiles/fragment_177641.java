/* Note: 48 to 57 is ascii values of 0,1, 2,...9 respectively
   code is made more readable ascii values are not used now 
 */
package com;

import java.util.Scanner;

public class Dis {
    public static void main(String[] args) {
        System.out.println("Enter the string");
        Scanner ob = new Scanner(System.in);
        String s = ob.nextLine();
        System.out.println(Digitinstring(s));
        ob.close();
    }

    private static boolean Digitinstring(String s) {
        boolean result = false;
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j)>='0' && s.charAt(j)<='9')
           {
               result=true;
               break;
           }
        }
        return result;
    }
}