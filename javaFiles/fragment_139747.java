import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("test.txt"));

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                System.out.println(sc.nextInt());
            } else {
                // Just consume the next token
                sc.next();
            }
        }           
        sc.close();
    }
}