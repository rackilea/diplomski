import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the file location and name.");
        String filepath = input.next();
        File file = new File(filepath); 
        if (file.exists()) System.out.println("EXISTS!"); else System.out.println("DOESN'T EXIST!");
    }

}