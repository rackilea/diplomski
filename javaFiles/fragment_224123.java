import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class FileManipulations {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> runGUI());
    }

    public static void runGUI() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        System.out.println(file.exists());
        Scanner fromFile = new Scanner(file);
    }
}