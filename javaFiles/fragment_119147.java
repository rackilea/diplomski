import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class Board2 extends JPanel {

   private static final int SIDE_LEN = 80;
   private static final Dimension SQUARE_SZ = new Dimension(SIDE_LEN, SIDE_LEN);
   private static final Color EDGE_COLOR = new Color(165, 245, 250);
   private static final Color DARK_SQR_COLOR = Color.LIGHT_GRAY;
   private static final Color LIGHT_SQR_COLOR = Color.WHITE;
   private JPanel[][] chessSquares = new JPanel[8][8]; 

   public Board2() {
      setLayout(new GridLayout(10, 10)); // sorry for magic numbers
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++) {
            if ((i == 0 || i == 9) && (j == 0 || j == 9)) {
               add(createEdgePanel(""));
            } else if (i == 0 || i == 9) {
               String text = String.valueOf((char) (j + 'a' - 1));
               add(createEdgePanel(text));
            } else if (j == 0 || j == 9) {
               String text = String.valueOf(8 - i + 1);
               add(createEdgePanel(text));
            } else {
               JPanel panel = createSquare(i, j);
               add(panel);
            }
         }
      }
   }

   private JPanel createSquare(int i, int j) {
      JPanel panel = new JPanel(new GridBagLayout());
      Color c = (i % 2 == j % 2) ? LIGHT_SQR_COLOR : DARK_SQR_COLOR;
      panel.setBackground(c);
      panel.setPreferredSize(SQUARE_SZ);
      panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
      return panel;
   }

   private JPanel createEdgePanel(String text) {
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      JPanel panel = new JPanel(new GridBagLayout());
      panel.add(label);
      panel.setBackground(EDGE_COLOR);
      panel.setPreferredSize(SQUARE_SZ);
      panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
      return panel;
   }

   private static void createAndShowGui() {
      Board2 mainPanel = new Board2();

      JFrame frame = new JFrame("Board2");
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