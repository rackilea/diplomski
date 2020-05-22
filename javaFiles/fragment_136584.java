package custom_file_chooser;

import java.io.File;

import javax.swing.JFileChooser;

public class CustomFileChooserRunner {


    public static void main(String[] args) {

        MyFileChooser f = new MyFileChooser("hello");
        int result;

        result = f.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();
            System.out.println("You chose to open: " +
                    file.getName() + (file.isDirectory() ? " directory" : " file"));
        }
    }
}