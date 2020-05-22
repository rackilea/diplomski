import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileReader {
    public static void main(String[] args) throws FileNotFoundException {
        int count = 0;
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try (Scanner in = new Scanner(new FileInputStream(file), "UTF-8")) {
            while (in.hasNext()) {
                String token = in.next();
                if (token.equals("if") || token.equals("ot")) {
                    count++;
                }
            }
        }
        System.out.println("The word count is " + count);
    }
}