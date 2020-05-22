import javax.swing.*;

class CenterTheDialog {

    CenterTheDialog() {
        for (int ii=1; ii<4; ii++) {
            JFrame f = new JFrame("Frame " + ii);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            f.setSize(400,300);
            f.setLocationByPlatform(true);
            f.setVisible(true);

            JDialog d = new JDialog(f);
            d.setSize(300,200);
            d.setLocationRelativeTo(f);
            d.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CenterTheDialog();
        });
    }
}