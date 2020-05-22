import javax.swing.*;
import javax.swing.colorchooser.*;

class ColorChooserTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JColorChooser cc = new JColorChooser();
                AbstractColorChooserPanel[] panels = cc.getChooserPanels();
                for (AbstractColorChooserPanel accp : panels) {
                    if (accp.getDisplayName().equals("HSB")) {
                        JOptionPane.showMessageDialog(null, accp);
                    }
                }
            }
        });
    }
}