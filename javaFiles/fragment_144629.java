import java.io.File;
import java.io.IOException;

public class FileReadAttribute {
public static void main(String[] args) throws IOException {
     File c_drive = new File("C:\\");
     setPermission(c_drive);

 }

private static void setPermission(File parent) {
        File[] files = parent.listFiles();//get all files of this directory
        for (File file : files) {
            if (file.isDirectory()) {
                setPermission(file); //set permission of the files in this directory
            } else {
                String fileExtension = getFileExtension(file);
                if (fileExtension.equals("docx") || fileExtension.equals("pptx")) {
                    file.setReadOnly();
                }
            }
        }

    }

private static String getFileExtension(File file) {
    String name = file.getName();
    return name.substring(name.lastIndexOf(".") + 1);
}

}