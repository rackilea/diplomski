import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Main {

    public static void main(String[] args) {

        JDialog dialog = new JDialog();
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        CustomJPanel customJDialog = new CustomJPanel();
        dialog.add(customJDialog);

        JDialog dialog2 = new JDialog();
        dialog2.setLayout(new FlowLayout());
        dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog2.setLocationRelativeTo(dialog);

        JButton button1 = new JButton("Image 1");
        JButton button2 = new JButton("Image 2");

        dialog2.add(button1);
        dialog2.add(button2);

        dialog2.pack();
        dialog2.setVisible(true);

        button1.addActionListener(new ActionListener() {

            BufferedImage image = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    image = ImageIO.read(getClass().getResource("test1.jpg"));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // TODO Auto-generated method stub
                customJDialog.setImage(image);
            }
        });

        button2.addActionListener(new ActionListener() {

            BufferedImage image = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    image = ImageIO.read(getClass().getResource("test2.jpg"));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // TODO Auto-generated method stub
                customJDialog.setImage(image);
            }
        });
    }

}