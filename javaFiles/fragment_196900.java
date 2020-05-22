import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ImageLabelAction {
    private JLabel imageBlock;
    private ImageIcon koala = new ImageIcon("koala.jpg");
    public static void main(String [] args) {
        new ImageLabelAction().gui();
    }
    private void gui() {
        JFrame frame = new JFrame();
        frame.setTitle("Frame with Image Label");
        imageBlock = new JLabel();
        imageBlock.setPreferredSize(new Dimension(100, 100));
        imageBlock.setOpaque(true);
        imageBlock.setBackground(Color.white);
        imageBlock.setBorder(BorderFactory.createLineBorder(Color.black));
        imageBlock.setIcon(koala);
        imageBlock.addMouseListener(new PictureRemoveListener());
        frame.add(imageBlock);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(250, 250);        
        frame.setVisible(true);
    }
    private class PictureRemoveListener extends MouseAdapter {
        @Override public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                imageBlock.setIcon(null);
            }
        }
    }
}