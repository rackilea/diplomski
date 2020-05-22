import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String chosen_f_name = "C:\\Users\\username\\Documents\\Project\\projectname\\data_file.txt";
        System.out.println(chosen_f_name);
        String fileName = chosen_f_name.substring(chosen_f_name.lastIndexOf("\\") + 1);
        System.out.println(fileName);

        // Alternatively, you can use File.separator to avoid hard coded platform
        // dependent separator e.g.
        URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
        String file = location.getFile()+"Main.java";
        System.out.println(file);
        String fName = file.substring(file.lastIndexOf(File.separator) + 1);
        System.out.println(fName);
    }
}