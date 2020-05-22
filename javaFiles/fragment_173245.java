import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

class InvisiButton {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                int size = 30;
                JPanel gui = new JPanel(new GridLayout(4,10,4,4));
                for (int ii=0; ii<40; ii++) {
                    JButton b = new JButton();
                    b.setContentAreaFilled(false);
                    b.setIcon(new ImageIcon(
                        new BufferedImage(size,size,BufferedImage.TYPE_INT_RGB)));
                    b.setRolloverIcon(new ImageIcon(
                        new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB)));
                    b.setBorder(null);
                    gui.add(b);
                }

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}