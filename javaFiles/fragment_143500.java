import java.awt.*;
import javax.swing.*;

public class PixelArtistGUI extends JFrame {
    public PixelArtistGUI() {
        setTitle("PixelArtist");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel contentPane = new JPanel(new GridBagLayout());
        setContentPane(contentPane); // <<<<<
        contentPane.setPreferredSize(new Dimension(500, 500)); // <<<<<
        GridBagConstraints c = new GridBagConstraints();

        JButton b;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                b = new JButton();
                c.gridx = i;
                c.gridy = j;
                contentPane.add(b,c);
            }
        }
        pack(); // <<<
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // <<<
            @Override
            public void run() {
                try {
                    new PixelArtistGUI().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}