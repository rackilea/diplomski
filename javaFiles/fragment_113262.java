import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TestDifferentStyles {
    private void initUI() {
        JFrame frame = new JFrame(TestDifferentStyles.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StyledDocument doc = new DefaultStyledDocument();
        JTextPane textPane = new JTextPane(doc);
        textPane.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has "
                + "been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of "
                + "type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the "
                + "leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the"
                + " release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing "
                + "software like Aldus PageMaker including versions of Lorem Ipsum.");

        Random random = new Random();
        for (int i = 0; i < textPane.getDocument().getLength(); i++) {
            SimpleAttributeSet set = new SimpleAttributeSet();
            // StyleConstants.setBackground(set, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            StyleConstants.setForeground(set, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            StyleConstants.setFontSize(set, random.nextInt(12) + 12);
            StyleConstants.setBold(set, random.nextBoolean());
            StyleConstants.setItalic(set, random.nextBoolean());
            StyleConstants.setUnderline(set, random.nextBoolean());

            doc.setCharacterAttributes(i, 1, set, true);
        }

        frame.add(new JScrollPane(textPane));
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestDifferentStyles().initUI();
            }
        });
    }

}