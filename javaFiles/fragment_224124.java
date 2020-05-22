import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class FileManipulations {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> runGUI());
    }

    public static void runGUI() {
        JFileChooser chooser = new JFileChooser();
        switch (chooser.showOpenDialog(null)) {
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();
                System.out.println(file.exists());
                try (Scanner fromFile = new Scanner(file)) {
                    while (fromFile.hasNextLine()) {
                        String text = fromFile.nextLine();
                        System.out.println(text);
                    }
                } catch (FileNotFoundException exp) {
                    exp.printStackTrace();
                }
                break;
        }
    }
}