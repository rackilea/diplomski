import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontTest extends JFrame {

    public FontTest() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new TestStringComponent());
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FontTest().setVisible(true);
            }
        });
    }
}

class TestStringComponent extends JComponent {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(getForeground());

        Font mainFont = new Font("Segoe Print", Font.PLAIN, 25);
        Font fallbackFont = new Font("Serif", Font.PLAIN, 25);

        String s = "Test 漢鼎繁古印 Test 漢鼎繁古印 Test";

        g2d.drawString(createFallbackString(s, mainFont, fallbackFont).getIterator(), 20, 30);
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 40);
    }

    private AttributedString createFallbackString(String text, Font mainFont, Font fallbackFont) {
        AttributedString result = new AttributedString(text);

        int textLength = text.length(); 
        result.addAttribute(TextAttribute.FONT, mainFont, 0, textLength);

        boolean fallback = false;
        int fallbackBegin = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean curFallback = !mainFont.canDisplay(text.charAt(i));
            if (curFallback != fallback) {
                fallback = curFallback;
                if (fallback) {
                    fallbackBegin = i;
                } else {
                    result.addAttribute(TextAttribute.FONT, fallbackFont, fallbackBegin, i);
                }
            }
        }
        return result;
    }
}