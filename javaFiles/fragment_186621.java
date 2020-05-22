import java.io.*;

public class ListDir {

    public static void main(String args[]) {
        File root;
        if (args.length > 0) root = new File(args[0]);
        else root = new File(System.getProperty("user.dir"));
        ls(root); 
    }

    private static void ls(File f) { 
        File[] list = f.listFiles();
        for (File file : list) {
            if (file.isDirectory()) ls(file);
            else System.out.println(file);
        }
    }
}