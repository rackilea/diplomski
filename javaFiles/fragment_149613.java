package mediaz;
import javazoom.jl.player.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.swing.JFileChooser;


public class audio {
    private String filePath = "";

    public File fopen() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtermp3 = new FileNameExtensionFilter("MPEG-2
            Audio Layer III ", "
            mp3 ");
        fc.setFileFilter(filtermp3); int ret = fc.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            this.filePath = file.getAbsolutePath()
            return filepath; // should be file
        } else // give me braces please!
            return null;
    }

    // try to stick to camelCase, it is the 'Java' way
    void playsound() { 
        System.out.println("You pressed play.");
        // streams implement AutoCloseable, use it
        // also, you were not closing fis as it was
        try (FileInputStream fis = new FileInputStream(this.filePath)) {
            Player playMP3 = new Player(fis);
            playMP3.play();
        } catch (Exception e) {
            System.out.println("Error: '" + e + "'");
        }
    }
}