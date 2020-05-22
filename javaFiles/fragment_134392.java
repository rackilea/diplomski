import java.io.File;
import java.util.Vector;

public class CallThreadFiles {

    public static void main (String[] args) {

        final ThreadFiles  task = new ThreadFiles();                
        Vector<File> files = null;

        try {
            files = task.call();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (File f: files) {
            System.out.println(f.getName());            
        }

    }
}