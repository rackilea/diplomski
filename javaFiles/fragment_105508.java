import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChessGame2 extends JPanel {
   private static final int RANKS = 8;
   private static final int FILES = RANKS;
   private static final int SIDE = 80;
   private static final Dimension SQUARE_SIZE = new Dimension(SIDE, SIDE);
   private static final Color LIGHT_COLOR = new Color(238, 221, 187);
   private static final Color DARK_COLOR = new Color(204, 136, 68);
   private static final int GAP = 5;

   private JPanel chessBoard = new JPanel(new GridLayout(RANKS, FILES));

   public ChessGame2() {
      for (int rank = 0; rank < RANKS; rank++) {
         for (int file = 0; file < FILES; file++) {
            JPanel square = new JPanel();
            square.setPreferredSize(SQUARE_SIZE);
            Color bg = (rank % 2 == file % 2) ? LIGHT_COLOR : DARK_COLOR; 
            square.setBackground(bg);
            chessBoard.add(square);
         }
      }

      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.insets = new Insets(0, 2 * GAP, 0, 2 * GAP);
      add(createRankPanel(), gbc);

      gbc.gridx = 2;
      gbc.anchor = GridBagConstraints.EAST;
      add(createRankPanel(), gbc);

      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.SOUTH;
      gbc.insets = new Insets(GAP, 0, GAP, 0);
      add(createFilePanel(), gbc);

      gbc.gridy = 2;
      gbc.anchor = GridBagConstraints.NORTH;
      add(createFilePanel(), gbc);      

      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.insets = new Insets(0, 0, 0, 0);
      add(chessBoard, gbc);
   }

   private JPanel createFilePanel() {
      JPanel filePanel = new JPanel(new GridLayout(1, 0));
      for (int i = 0; i < FILES; i++) {
         char fileChar = (char) ('A' + i);
         filePanel.add(new JLabel(String.valueOf(fileChar), SwingConstants.CENTER));
      }
      return filePanel;
   }

   private JPanel createRankPanel() {
      JPanel rankPanel = new JPanel(new GridLayout(0, 1));
      for (int i = 0; i < RANKS; i++) {
         int row = RANKS - i;
         rankPanel.add(new JLabel(String.valueOf(row)));
      }
      return rankPanel;
   }

   private static void createAndShowGui() {
      ChessGame2 mainPanel = new ChessGame2();

      JFrame frame = new JFrame("Chess Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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