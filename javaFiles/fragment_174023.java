import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;

public class FallbackFont {

    private JComponent ui = null;
    private final String[] fontFamilies = GraphicsEnvironment.
            getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String[] examplesTexts = {
        "The quick brown fox jumps over the lazy dog.", // English
        "\u6253\u5370\u8FC7\u671F\u8BC1\u4E66\u8BB0\u5F55", // Chinese
        "\u0627\u0644\u0633\u0644\u0627\u0645 "
        + "\u0639\u0644\u064A\u0643\u0645", // Arabic
        new String(Character.toChars(128176))
    };
    String[] preferredFonts = {
        "DejaVu Sans Mono",
        "Microsoft JhengHei",
        "Noto Sans CJK TC Black", // has strange display problem here .. 
    };

    FallbackFont() {
        initUI();
    }

    private HashMap getCompatibleFonts(String text) {
        HashMap cF = new HashMap<>();
        for (String font : fontFamilies) {
            Font f = new Font(font, Font.PLAIN, 1);
            if (f.canDisplayUpTo(text) < 0) {
                cF.put(font, f);
            }
        }
        return cF;
    }

    private Font getPreferredFontForText(String text) {
        HashMap compatibleFonts = getCompatibleFonts(text);
        for (String preferredFont : preferredFonts) {
            Font font = (Font) compatibleFonts.get(preferredFont);
            if (font != null) {
                return font;
            }
        }
        Set keySet = compatibleFonts.keySet();
        String firstCompatibleFont = (String) keySet.iterator().next();
        return (Font) compatibleFonts.get(firstCompatibleFont);
    }

    public final void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new GridLayout(0, 2, 4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));
        for (String text : examplesTexts) {
            Font font = getPreferredFontForText(text);
            JButton b = new JButton(text);
            b.setFont(font.deriveFont(b.getFont().getSize2D()));
            ui.add(b);
            ui.add(new JLabel(font.getName()));
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            FallbackFont o = new FallbackFont();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.pack();
            f.setMinimumSize(f.getSize());

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}