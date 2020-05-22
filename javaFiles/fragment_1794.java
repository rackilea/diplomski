import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by Lenovo on 02/12/2018.
 */
public class FileMove {
    public static void main(String a[])

    {
        try {

            File source = new File("C:\\Users\\sh370472\\Downloads");
            File dest = new File("E:\\Query\\");

            FileUtils.copyDirectory(source, dest, new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    boolean source = pathname.getName().toLowerCase().endsWith(".csv");

                    if (source) {
                        pathname.deleteOnExit();
                        return true;
                    }
                    return false;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}