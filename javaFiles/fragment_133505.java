import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("I have something to say, it's beter to burn out then to fade away.").
                            append("  This is a very long String to see if you can wrap with in").
                            append("the available space");
            setLayout(new BorderLayout());
            JTextArea ta = new JTextArea(10, 20);
            ta.setOpaque(false);
            ta.setEditable(false);
            ta.setBorder(null);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setText(sb.toString());
            add(ta);
        }

    }

}