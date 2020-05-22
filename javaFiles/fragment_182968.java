import javax.swing.*;
import java.net.*;
import java.io.*;
import java.nio.file.*;

public class FileChooserExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFileChooser chooser = new JFileChooser();
                int option = chooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    download(file);
                } else
                    System.out.println("No file was selected.");
            }
        });
    }

    static void download(File dest) {
        try {
            URL url = new URL("http://stackoverflow.com");
            Files.copy(url.openStream(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}