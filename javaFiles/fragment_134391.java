import java.io.File;
import java.util.Vector;
import java.util.concurrent.Callable;

public class ThreadFiles implements Callable<Vector<File>> {

    @Override
    public Vector<File> call() throws Exception {
        File[] files = new File("C:/PathToFiles").listFiles();
        Vector<File> vectorFiles = new Vector<File>();

        for (File file : files) {
            vectorFiles.add(file);
        }
        return vectorFiles; 
    }
}