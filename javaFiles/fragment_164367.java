import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Test {

    public static void main(String[] args) {
        try {
            System.out.println(new File("Pacifico.ttf").exists());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Pacifico.ttf"));

            String text = "Happy, Happy, Joy, Joy";
            double width = cmToPixel(13.0, 72.0);
            BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            float fontSize = pointToFit(width, text, font, g2d, 0, (float) width);
            System.out.println(width);
            System.out.println(fontSize);
            font = font.deriveFont(fontSize);
            FontMetrics fm = g2d.getFontMetrics(font);
            int height = fm.getHeight();
            g2d.dispose();

            img = new BufferedImage((int) Math.round(width), height, BufferedImage.TYPE_INT_ARGB);
            g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
            g2d.setFont(font);
            fm = g2d.getFontMetrics();
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, 0, fm.getAscent());
            g2d.dispose();

            JOptionPane.showConfirmDialog(null, new ImageIcon(img));
        } catch (IOException | FontFormatException e) {
            //Handle exception
        }
    }

    public static Float pointToFit(double width, String text, Font font, Graphics2D g2d) {
        return pointToFit(width, text, font, g2d, 0f, Float.MAX_VALUE);
    }

    protected static int widthOfText(String text, Font font, float fontSize, Graphics2D g2d) {
        font = font.deriveFont(fontSize);
        FontMetrics fm = g2d.getFontMetrics(font);
        int textWidth = fm.stringWidth(text);
        return textWidth;
    }

    public static Float pointToFit(double width, String text, Font font, Graphics2D g2d, float min, float max) {
        float fontSize = min + ((max - min) / 2f);
        NumberFormat nf = NumberFormat.getInstance();
        font = font.deriveFont(fontSize);
        FontMetrics fm = g2d.getFontMetrics(font);
        int textWidth = fm.stringWidth(text);

        if (fontSize == min || fontSize == max) {
            return fontSize;
        }

        if (textWidth < width) {
            return pointToFit(width, text, font, g2d, fontSize, max);
        } else if (textWidth > width) {
            return pointToFit(width, text, font, g2d, min, fontSize);
        }
        return fontSize;
    }

    public static double cmToPixel(double cm, double dpi) {
        return (dpi / 2.54) * cm;
    }

}