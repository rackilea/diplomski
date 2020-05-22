import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @see https://stackoverflow.com/a/12827643/230513
 * @see https://stackoverflow.com/questions/4755524
 */
public class HtmlView extends JPanel {

    private static final String EXAMPLE = "http://www.example.com";
    private final JEditorPane jep;

    public HtmlView(String url) {
        super(new GridLayout(1, 1));
        jep = new JEditorPane();
        try {
            jep.setPage(EXAMPLE);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
        jep.setEditable(false);
        this.add(new JScrollPane(jep));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 200);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new HtmlView(EXAMPLE));
                panel.add(new HtmlView(EXAMPLE));
                panel.add(new HtmlView(EXAMPLE));
                f.add(new JScrollPane(panel));
                f.pack();
                f.setSize(640, 480);
                f.setVisible(true);
            }
        });
    }
}