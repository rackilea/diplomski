import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
                frame.add(new GuessingGame());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class GuessingGame extends JPanel {

        public GuessingGame() {
            setLayout(new GridBagLayout());
            JLabel label = new JLabel("<html>A few sentences giving either a definition or a<br> few hints about what the word could be</html>");
            WordPane wordPane = new WordPane("stackoverflow");
            JLabel wordCategory = new JLabel("Word Category");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(4, 4, 4, 4);
            add(label, gbc);
            add(wordPane, gbc);

            JPanel pnlWordCategory = new JPanel(new GridLayout(1, 6, 4, 4));
            pnlWordCategory.add(new LetterLabel("A"));
            pnlWordCategory.add(new LetterLabel("B"));
            pnlWordCategory.add(new LetterLabel("C"));
            pnlWordCategory.add(new LetterLabel("D"));
            pnlWordCategory.add(new LetterLabel("W"));
            pnlWordCategory.add(new LetterLabel("G"));
            add(wordCategory, gbc);
            add(pnlWordCategory, gbc);
        }

    }

    public class WordPane extends JPanel {

        private String word;
        private List<JTextField> fields;

        public WordPane(String text) {
            setLayout(new GridLayout(1, text.length(), 4, 4));
            fields = new ArrayList<>(text.length());
            for (int index = 0; index < text.length(); index++) {
                JTextField field = new JTextField(2);
                fields.add(field);
                add(field);
            }
        }

    }

        public class LetterLabel extends JLabel {

            public LetterLabel(String text) {
                this();
                setText(text);
            }

            public LetterLabel() {
                setBorder(new CompoundBorder(new LineBorder(Color.GRAY), new EmptyBorder(4, 4, 4, 4)));
            }

            @Override
            public Dimension getPreferredSize() {
                Insets insets = getInsets();
                Dimension size = new Dimension();
                FontMetrics fm = getFontMetrics(getFont());
                size.width = (insets.left + insets.right) + fm.stringWidth("M");
                size.height = (insets.top + insets.bottom) + fm.getHeight();
                return size;
            }

        }

}