import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoxLayoutDemo {
    private static void createAndShowGUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel a = new JPanel();
        a.setAlignmentX(Component.CENTER_ALIGNMENT);
        a.setPreferredSize(new Dimension(100, 100));
        a.setMaximumSize(new Dimension(100, 100)); // set max = pref
        a.setBorder(BorderFactory.createTitledBorder("aa"));
        JPanel b = new JPanel();
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setPreferredSize(new Dimension(50, 50));
        b.setMaximumSize(new Dimension(50, 50)); // set max = pref
        b.setBorder(BorderFactory.createTitledBorder("bb"));

        frame.getContentPane().add(a);
        frame.getContentPane().add(b);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();             
            }
        });
    }
}