import java.io.*;
import java.lang.*;
import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String parse = line.substring(0, line.lastIndexOf(':'));
            System.out.println(parse);
        }
    }
}