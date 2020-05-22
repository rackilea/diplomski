import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BlockUserFromFrame {

    BlockUserFromFrame() {
        JFrame f = new JFrame("Try to access frame!");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l = new JLabel("Access frame after dialog disappears!");
        l.setBorder(new EmptyBorder(50, 100, 50, 100));
        f.add(l);
        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);

        // use a constructor that allows us to specify a parent and modality
        JDialog d = new JDialog(f, true);
        JLabel l1 = new JLabel("Dismiss dialog to access frame!");
        l1.setBorder(new EmptyBorder(20, 100, 10, 100));
        d.add(l1);
        d.pack();
        d.setLocationRelativeTo(f);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            BlockUserFromFrame o = new BlockUserFromFrame();
        };
        SwingUtilities.invokeLater(r);
    }
}