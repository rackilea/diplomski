import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
    /**
     * Do this for thread safety
     * @param args
     */
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    /**
     * create the JFrame
     */
    private static void createGUI() {
        JFrame jf = new JFrame();

        addComponents(jf.getContentPane());

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
    }

    /**
     * add the components
     * ALL YOUR NEW TIC TAC TOE RELATED JPANELS, JTEXTFIELDS, ETC. WILL GO HERE!
     * @param pane
     */
    private static void addComponents(Container pane) {
        pane.setLayout(new FlowLayout());

        JTextArea jta = new JTextArea("some text");
        JScrollPane jsp = new JScrollPane(jta);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        pane.add(jsp);
    }
}