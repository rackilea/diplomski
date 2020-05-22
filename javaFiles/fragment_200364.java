import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class UseLoggingOutputStream {
    public void myMethod() {
        String file = "c:\\system.txt";
        try {
            FileOutputStream outStr = new FileOutputStream(file, true);
        } catch(FileNotFoundException fnfe) { 
            System.out.println(fnfe.getMessage());
        } 
    }
}