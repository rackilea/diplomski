import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        BufferedWriter f = null;
        try {
            f = new BufferedWriter(new FileWriter("C:\\A.txt"));
            f.write("Hello World");
        }
        catch(IOException e) {
            System.out.println(e);
        }
        finally {
            if (f != null)
                f.close();  
        }
    }
}