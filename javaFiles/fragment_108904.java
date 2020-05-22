import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class ShowWordPanel extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = 250;
   private static final Font WORD_FONT = new Font(Font.DIALOG, Font.BOLD, 20);
   private String word = "example";

   // Change the name of this method from getXxx to setXxx 
   public void setWord(String input) {
      this.word = input;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setFont(WORD_FONT); // let's make it big enough to see well
      g.drawString(word, 75, 100); // changed the location to make it easier to see
   }

   @Override // so that the JPanel wil be big enough to show the text
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }
}