import java.awt.*;
import javax.swing.*;
import java.io.File;

class ForeignImageInPane {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                File f = new File("index.html");
                try {
                    JEditorPane jep = new JEditorPane(f.toURI().toURL());

                    JScrollPane sp = new JScrollPane(jep);
                    sp.setPreferredSize(new Dimension(400,200));

                    JOptionPane.showMessageDialog(null, sp);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}