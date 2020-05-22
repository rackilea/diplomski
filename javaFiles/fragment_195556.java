import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class Test extends JFrame {

    public Test () throws IOException {
        getContentPane().setLayout(new BorderLayout(0, 0));

        JSplitPane splitPane = new JSplitPane();
        getContentPane().add(splitPane, BorderLayout.CENTER);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        splitPane.resetToPreferredSizes();

        BufferedImage myPicture = ImageIO
                .read(new URL("http://freecodebank.com/wp-content/uploads/2016/07/joinus-java.png"));
        JLabel lblNewLabel = new JLabel(new ImageIcon(myPicture));
        lblNewLabel.setMinimumSize(new Dimension(100, 80));
        splitPane.setLeftComponent(lblNewLabel);

        JLabel label = new JLabel(new ImageIcon(myPicture));
        label.setMinimumSize(new Dimension(100, 80));
        splitPane.setRightComponent(label);
    }

    public static void main(String[] args) throws IOException {
        Test a = new Test();
        a.setPreferredSize(new Dimension(1400, 900));
        a.pack();
        a.setVisible(true);
    }
}