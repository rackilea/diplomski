import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<File> results  = new ArrayList<>();
        walk(new File("/home/lwi/Documents"),results);

        System.out.println(results.size());

    }

    public static void walk(File dir, List<File> accum) {
        File[] files = dir.listFiles();

        if (files == null)
            return;

        for (File f : files) {
            if (f.isDirectory())
                walk(f, accum);
            else if (isTextFile(f))
                accum.add(f);
        }
    }

    private static boolean isTextFile(File f) {
        return f.getName().toLowerCase().endsWith(".txt");
    }

}