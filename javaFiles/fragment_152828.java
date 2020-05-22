import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.io.*;

public class TextFieldPLAF {

    TextFieldPLAF() {
        initUI();
    }

    public final void initUI() {
        UIManager.LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
        try {
            for (UIManager.LookAndFeelInfo lAFI : lafInfos) {
                saveImageOfLookAndFeel(lAFI);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveImageOfLookAndFeel(UIManager.LookAndFeelInfo lafi) throws IOException {
        String classname = lafi.getClassName();
        try {
            UIManager.setLookAndFeel(classname);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JComponent ui = new JPanel(new GridLayout(1, 0));
        ui.setBorder(new TitledBorder(classname));
        int cols = 13;
        JTextField tf;
        tf = new JTextField("Editable & Enabled", cols);
        ui.add(tf);
        tf = new JTextField("Not Editable", cols);
        tf.setEditable(false);
        ui.add(tf);
        tf = new JTextField("Not Enabled", cols);
        tf.setEnabled(false);
        ui.add(tf);
        JOptionPane.showMessageDialog(null, ui);
        BufferedImage bi = new BufferedImage(
                ui.getWidth(), ui.getHeight(), BufferedImage.TYPE_INT_RGB);
        ui.paint(bi.getGraphics());
        File dir = new File(System.getProperty("user.home"));
        File f = new File(dir, String.format("PLAF-%1s.png", classname));
        ImageIO.write(bi, "png", f);
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            new TextFieldPLAF();
        };
        SwingUtilities.invokeLater(r);
    }
}