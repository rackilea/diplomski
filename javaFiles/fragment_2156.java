import java.io.*;
import java.util.*;

class SO1 {

    public static void main(String args[])
    {
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        String arr[]=new String[]{"CBS-DELHI","RBS-JAIPUR","SBS-MEERUT"};

        for(String input:arr) {
            String individual_string[]=input.split("-");
            list1.add(individual_string[0]);
            list2.add(individual_string[1]); 
        }

        System.out.println("Printing List 1");

        for (String s:list1) {
            System.out.println(s);
        }

        System.out.println("Printing List 2");

        for (String s:list2) {
            System.out.println(s);
        }
    }
}