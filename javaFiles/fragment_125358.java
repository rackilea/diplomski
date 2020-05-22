import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelOnClick extends JFrame {

    public static void main(String[] args) {
    final JFrame frame = new JLabelOnClick();
    final JPanel panel = new JPanel();
    panel.setLayout(null);
    frame.setContentPane(panel);

    frame.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        // if you want an image instead, use the JLabel(Icon image)
        // constructor
        JLabel label = new JLabel("test");
        label.setBounds(e.getX(), e.getY(), label.getPreferredSize().width, label
            .getPreferredSize().height);
        panel.add(label);
        panel.validate();
        frame.repaint();
        }
    });

    frame.setSize(new Dimension(200, 200));
    frame.setVisible(true);
    }

}