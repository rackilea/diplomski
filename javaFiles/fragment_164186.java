import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.DefaultCaret;

public class TestEditorPane implements HyperlinkListener {

    private final class MyCaret extends DefaultCaret {

        @Override
        protected void adjustVisibility(Rectangle nloc) {

        }

    }

    JEditorPane dataDisplayer = new JEditorPane();
    private MyCaret caret;

    @Override
    public void hyperlinkUpdate(HyperlinkEvent arg0) {
        dataDisplayer.setText("<a href=''>Change Text</a><br><br><br><br><br><br><br><br><br><br>bla bla");

    }

    public void init() {
        JFrame frame = new JFrame();
        dataDisplayer.setEditable(false);
        caret = new MyCaret();
        dataDisplayer.setCaret(caret);
        dataDisplayer.add(new JButton());
        dataDisplayer.setContentType("text/html");
        JScrollPane jsp = new JScrollPane(dataDisplayer);
        dataDisplayer.setText("<a href=''>Change Text</a><br><br><br><br><br><br><br><br><br><br>bla");
        this.dataDisplayer.addHyperlinkListener(this);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jsp);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestEditorPane().init();
            }
        });
    }
}