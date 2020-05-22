import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Board2 extends JPanel {
   private static final int SIDE_LEN = 80;
   private static final Dimension SQUARE_SZ = new Dimension(SIDE_LEN, SIDE_LEN);
   private static final String SPRITE_PATH = "http://i.stack.imgur.com/memI0.png";
   private static final int SPRITE_ROWS = 2;
   private static final int SPRITE_COLS = 6;
   private static final Color EDGE_COLOR = new Color(165, 245, 250);
   private static final Color DARK_SQR_COLOR = Color.LIGHT_GRAY;
   private static final Color LIGHT_SQR_COLOR = Color.WHITE;
   private static final int ROWS = 8;
   private JLabel[][] chessSquares = new JLabel[ROWS][ROWS]; 
   private BufferedImage bigImage;
   private List<Icon> icons = new ArrayList<>();

   public Board2() throws IOException {
      URL imgUrl = new URL(SPRITE_PATH);
      bigImage = ImageIO.read(imgUrl);
      int w = bigImage.getWidth() / SPRITE_COLS;
      int h = bigImage.getHeight() / SPRITE_ROWS;
      for (int i = 0; i < SPRITE_ROWS; i++) {
         for (int j = 0; j < SPRITE_COLS; j++) {
            int x = (j * bigImage.getWidth()) / SPRITE_COLS;
            int y = (i * bigImage.getHeight()) / SPRITE_ROWS;
            BufferedImage spriteImg = bigImage.getSubimage(x, y, w, h);
            Icon spriteIcon = new ImageIcon(spriteImg);
            icons.add(spriteIcon);
         }
      }

      for (int i = 0; i < chessSquares.length; i++) {
         for (int j = 0; j < chessSquares[i].length; j++) {
            chessSquares[i][j] = new JLabel();
         }
      }

      setLayout(new GridLayout(ROWS + 2, ROWS + 2)); // sorry for magic numbers
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++) {
            if ((i == 0 || i == ROWS + 1) && (j == 0 || j == ROWS + 1)) {
               add(createEdgePanel(""));
            } else if (i == 0 || i == ROWS + 1) {
               String text = String.valueOf((char) (j + 'a' - 1));
               add(createEdgePanel(text));
            } else if (j == 0 || j == ROWS + 1) {
               String text = String.valueOf(ROWS - i + 1);
               add(createEdgePanel(text));
            } else {
               JPanel panel = createSquare(i, j);
               panel.add(chessSquares[i - 1][j - 1]);
               add(panel);
            }
         }
      }

      setPieces(0, 0, 2); // rooks
      setPieces(1, 0, 3); // knights
      setPieces(2, 0, 4); // bishops

      // kings and queens
      chessSquares[0][3].setIcon(icons.get(1));
      chessSquares[7][3].setIcon(icons.get(6 + 1));
      chessSquares[0][4].setIcon(icons.get(0));
      chessSquares[7][4].setIcon(icons.get(6 + 0));

      // pawns
      for (int i = 0; i < ROWS / 2; i++) {
         setPieces(i, 1, 5);
      }

   }

   private void setPieces(int colPos, int rowPos, int pieceIndex) {
      chessSquares[rowPos][colPos].setIcon(icons.get(pieceIndex));
      chessSquares[rowPos][ROWS - 1 - colPos].setIcon(icons.get(pieceIndex));
      chessSquares[ROWS - 1 - rowPos][colPos].setIcon(icons.get(6 + pieceIndex));
      chessSquares[ROWS - 1 - rowPos][ROWS - 1 - colPos].setIcon(icons
            .get(6 + pieceIndex));
   }

   private void setPiece(int colPos, int pieceIndex) {
      chessSquares[0][colPos].setIcon(icons.get(pieceIndex));
      chessSquares[ROWS - 1][ROWS - 1 - colPos].setIcon(icons.get(6 + pieceIndex));
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
      Board2 mainPanel = null;
      try {
         mainPanel = new Board2();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

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