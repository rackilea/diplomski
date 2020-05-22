import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics; 

public int measureText(Graphics g, String text) {
   g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
   FontMetrics metrics = g.getFontMetrics();

   return metrics.stringWidth(text);
}