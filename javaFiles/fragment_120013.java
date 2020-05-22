import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main(String... args) throws Exception {
        URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location.getFile());
        Scanner fileScanner = new Scanner(new File(location.getFile() + "data.txt"));
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
    }
}