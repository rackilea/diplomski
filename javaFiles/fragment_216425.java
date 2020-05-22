import java.awt.Component;
import javax.swing.*;

class CenterTheDialog {

    CenterTheDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Show over parent?");
        for (int ii=1; ii<4; ii++) {
            JFrame f = new JFrame("Frame " + ii);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Component parent = (JOptionPane.OK_OPTION==result ? f : null);

            f.setSize(400,300);
            f.setLocationByPlatform(true);
            f.setVisible(true);

            JDialog d = new JDialog(f);
            d.setTitle("Dialog " + ii);
            d.setSize(300,200);
            d.setLocationRelativeTo(parent);
            d.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CenterTheDialog();
            }
        });
    }
}