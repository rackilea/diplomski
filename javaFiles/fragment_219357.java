import java.io.*;
import java.util.*;

class CompareFiles{
    public static void main(String args[]) throws Exception{

        Scanner kb = new Scanner(System.in);
        String name;
        String curr;

        java.io.File dictionary = new java.io.File("./src/main/resources/Google_JP.txt");
        Scanner dictScanner = new Scanner(dictionary); 

        java.io.File list = new java.io.File("./src/main/resources/Google_JP_HTML.txt");
        //Scanner listScanner = new Scanner(list);  
        try
        {
        while(dictScanner.hasNextLine()){
            System.out.println("inside dictonary scanner");
            curr=dictScanner.next();
            try (Scanner listScanner = new Scanner(list);){
                while(listScanner.hasNextLine()){
                    System.out.println("inside list scanner");
                    name=listScanner.next();

                    if(curr.contains(name)) System.out.println(name);
                }
            }
        }
    } catch(NoSuchElementException e) {
            e.printStackTrace();
    }
}

}