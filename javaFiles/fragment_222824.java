import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class TestTextComponents extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField jTextField1;
    private JTextField jTextField2;

    public TestTextComponents() {
        initComponents();
    }

    private void initComponents() {
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Text component persistent selection");
        setResizable(false);
        getContentPane().add(new JLabel(
                "Please skip between text fields and watch persistent selection: "));
        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2);
        jTextField1.setCaret(new HighlightCaret());
        jTextField2.setCaret(new HighlightCaret());
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       // setBounds((screenSize.width - 600) / 2, (screenSize.height - 70) / 2, 600, 70);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTextComponents().setVisible(true);
            }
        });
    }
}

class HighlightCaret extends DefaultCaret {

    private static final Highlighter.HighlightPainter unfocusedPainter =
            new DefaultHighlighter.DefaultHighlightPainter(new Color(230, 230, 210));
    private static final long serialVersionUID = 1L;
    private boolean isFocused;

    @Override
    protected Highlighter.HighlightPainter getSelectionPainter() {
        return isFocused ? super.getSelectionPainter() : unfocusedPainter;
    }

    @Override
    public void setSelectionVisible(boolean hasFocus) {
        if (hasFocus != isFocused) {
            isFocused = hasFocus;
            super.setSelectionVisible(false);
            super.setSelectionVisible(true);
        }
    }
}