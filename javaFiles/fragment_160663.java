import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame {
    public static void main(String[] args){
        final JFrame frame = new JFrame("Add Component");
        final Canvas canvas = new Canvas();
        canvas.setBackground(Color.BLACK);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked");
                frame.add(canvas);
                frame.pack();
                frame.repaint();
            }
        });


        frame.setMinimumSize(new Dimension(320,240));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}