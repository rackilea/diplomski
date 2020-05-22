import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class CenteredText extends JPanel {
   private static final String TOP_TEXT = "Top Text";
   private static final String CENTER_TEXT = "Center Text";
   private static final String BOTTOM_TEXT = "Bottom Text";
   public CenteredText() {
      JLabel topLabel = new JLabel(TOP_TEXT, SwingConstants.CENTER);
      topLabel.setFont(topLabel.getFont().deriveFont(Font.BOLD, 20f));

      JLabel centerLabel = new JLabel(CENTER_TEXT, SwingConstants.CENTER);
      centerLabel.setFont(centerLabel.getFont().deriveFont(Font.BOLD, 80f));
      int ebGap = 20;
      centerLabel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));

      JLabel bottomLabel = new JLabel(BOTTOM_TEXT, SwingConstants.CENTER);
      bottomLabel.setFont(bottomLabel.getFont().deriveFont(Font.PLAIN, 8f));

      setLayout(new BorderLayout());
      add(topLabel, BorderLayout.PAGE_START);
      add(centerLabel, BorderLayout.CENTER);
      add(bottomLabel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGui() {
      CenteredText mainPanel = new CenteredText();

      JFrame frame = new JFrame("CenteredText");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}