import javax.swing.*;
import java.awt.*;

public class ScratchSpace {

    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        final MyTextPane textPane = new MyTextPane();
        frame.add(textPane);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class MyTextPane extends JTextPane {
        public MyTextPane() {
            super();
            setText("Hello World");
            setOpaque(false);

            // this is needed if using Nimbus L&F - see http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6687960
            setBackground(new Color(0,0,0,0));
        }

        @Override
        protected void paintComponent(Graphics g) {
            // set background green - but can draw image here too
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());

            // uncomment the following to draw an image
            // Image img = ...;
            // g.drawImage(img, 0, 0, this);


            super.paintComponent(g);
        }
    }
}