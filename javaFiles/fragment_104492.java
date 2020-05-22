import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShowLabelImage {

    public static void main(String[] args) {
        new ShowLabelImage();
    }

    private JLabel label;

    private List<BufferedImage> images;
    private int currentPic = 0;

    public ShowLabelImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                images = new ArrayList<>(2);
                try {
                    images.add(ImageIO.read(new File("path/to/pic1")));
                    images.add(ImageIO.read(new File("path/to/pic2")));
                } catch (IOException exp) {
                    exp.printStackTrace();
                }

                label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);

                JButton switchPic = new JButton("Switch");
                switchPic.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        currentPic++;
                        if (currentPic >= images.size()) {
                            currentPic = 0;
                        }
                        label.setIcon(new ImageIcon(images.get(currentPic)));
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(label);
                frame.add(switchPic, BorderLayout.SOUTH);
                switchPic.doClick();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}