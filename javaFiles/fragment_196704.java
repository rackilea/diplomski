1. Thanks a lot for all your support guys
 2. Finally I found the solution.


----------
package demo.practice.java;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        System.out.println("Enter String");
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();

        //split into words
        String[] words = input.split("(?=[A-Z])");

        words[0] = capitalizeFirstLetter(words[0]);

        //join
        StringBuilder builder = new StringBuilder();
        for ( String s : words ) {
            builder.append(s).append(" ");
        }

       // System.out.println(builder.toString());
        System.out.println("Output String--->" +builder.toString());

    }

    private static String capitalizeFirstLetter(String in) {
        return in.substring(0, 1).toUpperCase() + in.substring(1);
    }

}