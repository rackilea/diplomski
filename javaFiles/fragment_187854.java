import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleLabel {

    public static void main(String[] args) {
        new SimpleLabel();
    }

    public SimpleLabel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JLabel label = new JLabel(new ImageIcon("C:\\hold\\thumbnails\\_cg_836___Tilting_Windmills___by_Serena_Clearwater.png"));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setLayout(new BorderLayout());

                JLabel child = new JLabel("Can you see me?");
                child.setForeground(Color.WHITE);
                child.setFont(label.getFont().deriveFont(Font.BOLD, 24f));
                child.setHorizontalAlignment(JLabel.CENTER);
                child.setVerticalAlignment(JLabel.CENTER);
                child.setHorizontalTextPosition(JLabel.CENTER);
                child.setVerticalTextPosition(JLabel.CENTER);
                label.add(child);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(label);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}