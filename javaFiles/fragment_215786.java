import java.io.*;
import java.util.*;

public class Reader {

    private Scanner s;

    public boolean openFile() {
        try {
            s = new Scanner(new File("file.txt"));
            return true;
        } catch (Exception e) {
            System.out.println("File not found. Try again.");
            return false;
        }
    }

    public void readFile() {
        while (s.hasNext()) {
            String a = s.next();
            String b = s.next();
            String c = s.next();
            int d = s.nextInt();
            int e = s.nextInt();
            int f = s.nextInt();
     }
}