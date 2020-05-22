import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/a/31360762/230513 */
public class AttributedStringTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new AttributedStringTest()::display);
    }

    private void display() {
        JFrame frame = new JFrame("AttributedString superscript with font");
        frame.getContentPane().add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // superscript and bold only works fine
                AttributedString test1 = new AttributedString("test superscript and bold");
                test1.addAttribute(TextAttribute.SIZE, 28, 0, 25);
                test1.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 5, 16);
                test1.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, 21, 25);

                // both superscript and bold is only rendered as bold
                AttributedString test2 = new AttributedString("test superscript and bold");
                test2.addAttribute(TextAttribute.SIZE, 28, 0, 25);
                test2.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 5, 25);
                test2.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, 5, 25);

                g.drawString(test1.getIterator(), 5, 35);
                g.drawString(test2.getIterator(), 5, 70);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 80);
            }
        });

        // HTML label works fine
        frame.getContentPane().add(new JLabel(
            "<html>test <b>bold</b>, <sup>super</sup> and <b><sup>both</sup></b>", JLabel .CENTER),
            BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}