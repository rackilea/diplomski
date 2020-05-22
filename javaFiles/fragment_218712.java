package inputoutput;

import java.util.*;
import java.io.*;

public class input {

public static void main(String[] args) throws FileNotFoundException {

    String name;
    int lineCount = 0;

    File input = new File("C:\\Users\\Ceri\\workspace1\\inputoutput\\src\\inputoutput\\lab1task3.txt");
    Scanner in = new Scanner(input);

    while(in.hasNextLine()){
        lineCount++;

    }
    System.out.println(lineCount);


    }
}