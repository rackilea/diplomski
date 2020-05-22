import java.awt.*;
import javax.swing.*;

public class TestWrapLayout {
    public TestWrapLayout () {
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/stackoverflow2.png"));
        JPanel panel = new JPanel(new WrapLayout());
        for (int i = 1; i <= 250; i++) {
            JLabel iconlabel = new JLabel(icon);
            iconlabel.setLayout(new BorderLayout());
            JLabel textlabel = new JLabel(String.valueOf(i));
            textlabel.setHorizontalAlignment(JLabel.CENTER);
            textlabel.setForeground(Color.WHITE);
            textlabel.setFont(new Font("impact", Font.PLAIN,20));
            iconlabel.add(textlabel);
            panel.add(iconlabel);
        }
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(panel));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestWrapLayout();
            }
        });
    }
}