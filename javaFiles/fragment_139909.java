import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TestConsole {

    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec purus sapien, molestie dapibus feugiat vitae, pharetra lobortis lacus. Proin metus neque, malesuada vel consectetur vel, imperdiet et mauris. Vivamus vel tortor ipsum, ac semper ipsum. Nam semper tellus et purus molestie vestibulum. Aliquam erat volutpat. Nam vulputate facilisis magna id sollicitudin. Donec rutrum lorem sit amet orci lacinia congue. Ut nec nibh ipsum, et ornare tellus. Etiam nisi massa, mollis eu viverra id, luctus sed massa. Donec tincidunt erat vel sapien varius ultricies. Vivamus dui diam, consequat nec facilisis ut, interdum at enim. Vestibulum vestibulum, lorem nec cursus eleifend, purus orci egestas quam, vel sodales sem magna at nibh. Cras id nibh eleifend turpis sollicitudin adipiscing. Nunc aliquet posuere vulputate. Suspendisse id augue ut quam mattis sollicitudin. ";

    private static final int ROWS = 24;
    private static final int COLUMNS = 80;

    private JEditorPane console;

    public void append(final String s, final Color color) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    append(s, color);
                }
            });
            return;
        }
        Document document = console.getDocument();
        MutableAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, color);
        try {
            document.insertString(document.getLength(), s, sas);
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void initUI() {
        JFrame frame = new JFrame(TestConsole.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        console = new JEditorPane() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                FontMetrics fm = getFontMetrics(getFont());
                int colWidth = fm.charWidth('m');
                int rowHeight = fm.getHeight();
                d.width = Math.max(d.width, rowHeight * ROWS);
                d.height = Math.max(d.height, colWidth * COLUMNS);
                return d;
            }
        };
        console.setEditable(false);
        console.setContentType("text/html");
        console.setForeground(Color.WHITE);
        console.setBackground(Color.BLACK);
        console.setFont(new Font("Consolas", Font.PLAIN, 14));
        frame.add(new JScrollPane(console));
        frame.pack();
        frame.setVisible(true);
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            Random random = new Random();

            @Override
            public void run() {
                int start = random.nextInt(TEXT.length());
                int size = random.nextInt(TEXT.length() - start);
                append(TEXT.substring(start, start + size) + "\n", new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            }
        }, new Date(), 1000);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestConsole().initUI();
            }
        });
    }

}