import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class TicTacToeMain {

   private static void createAndShowGui() {
      TttView view = null;
      try {
         view = new TttView();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
      TttModel model = new TttModel();
      new TttControl(model, view);

      JFrame frame = new JFrame("Tic Tac Toe");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(view.getMainPanel());
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

enum TttPiece {
   EMPTY, X, O
}

class TttView {
   public static final String IMAGE = "/imgFolder/TicTacToe.png";
   private static final int GAP = 5;
   private JPanel mainPanel = new JPanel();
   private JPanel tttPanel = new JPanel();
   private Map<TttPiece, Icon> iconMap = new EnumMap<>(TttPiece.class);
   private JLabel[][] grid = new JLabel[TttModel.ROWS][TttModel.COLS];
   private TttControl control;

   public TttView() throws IOException {
      BufferedImage img = ImageIO.read(getClass().getResourceAsStream(IMAGE));
      Icon[] imgIcons = splitImg(img);
      iconMap.put(TttPiece.X, imgIcons[0]);
      iconMap.put(TttPiece.O, imgIcons[1]);
      iconMap.put(TttPiece.EMPTY, createEmptyIcon(imgIcons[0]));

      tttPanel.setLayout(new GridLayout(grid.length, grid[0].length, GAP, GAP));
      tttPanel.setBackground(Color.black);
      MyMouseAdapter mouseAdapter = new MyMouseAdapter();
      for (int row = 0; row < grid.length; row++) {
         for (int col = 0; col < grid[row].length; col++) {
            grid[row][col] = new JLabel(iconMap.get(TttPiece.EMPTY));
            grid[row][col].setOpaque(true);
            grid[row][col].setBackground(Color.LIGHT_GRAY);
            grid[row][col].addMouseListener(mouseAdapter);
            tttPanel.add(grid[row][col]);
         }
      }

      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      btnPanel.add(new JButton(new ClearAction("Clear", KeyEvent.VK_C)));
      btnPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));

      int blGap = 2;
      mainPanel.setLayout(new BorderLayout(blGap, blGap));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(blGap, blGap, blGap,
            blGap));
      mainPanel.add(tttPanel, BorderLayout.CENTER);
      mainPanel.add(btnPanel, BorderLayout.SOUTH);
   }

   public void setControl(TttControl control) {
      this.control = control;
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   private Icon createEmptyIcon(Icon icon) {
      int width = icon.getIconWidth();
      int height = icon.getIconHeight();
      BufferedImage img = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_ARGB);
      return new ImageIcon(img);
   }

   private Icon[] splitImg(BufferedImage img) {
      int w = img.getWidth();
      int h = img.getHeight();
      int gap = 5;
      Icon[] icons = new ImageIcon[2];
      icons[0] = new ImageIcon(img.getSubimage(0, 0, w / 2 - gap, h / 2 - gap));
      icons[1] = new ImageIcon(img.getSubimage(w / 2 + gap, 0, w / 2 - gap, h
            / 2 - gap));
      return icons;
   }

   private class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent e) {
         if (control == null) {
            return;
         }
         for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
               if (grid[row][col] == e.getSource()) {
                  control.gridPress(row, col);
               }
            }
         }
      }
   }

   private class ClearAction extends AbstractAction {

      public ClearAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (control != null) {
            control.clear();
         }
      }

   }

   private class ExitAction extends AbstractAction {
      public ExitAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (control != null) {
            control.exit(evt);
         }
      }
   }

   public void setGridIcon(int row, int col, TttPiece tttPiece) {
      grid[row][col].setIcon(iconMap.get(tttPiece));
   }

}

class TttControl {
   private TttModel model;
   private TttView view;

   public TttControl(TttModel model, TttView view) {
      this.model = model;
      this.view = view;
      view.setControl(this);

      model.addPropertyChangeListener(new ModelListener());
   }

   public void exit(ActionEvent evt) {
      Window win = SwingUtilities
            .getWindowAncestor((Component) evt.getSource());
      win.dispose();
   }

   public void gridPress(int row, int col) {
      try {
         model.gridPress(row, col);
      } catch (TttException e) {
         // TODO: notify user
         // e.printStackTrace();
      }
   }

   public void clear() {
      model.clear();
   }

   private class ModelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (TttModel.GRID_POSITION.equals(evt.getPropertyName())) {
            TttPiece[][] tttGrid = model.getTttGrid();
            for (int row = 0; row < tttGrid.length; row++) {
               for (int col = 0; col < tttGrid[row].length; col++) {
                  view.setGridIcon(row, col, tttGrid[row][col]);
               }
            }
         }
      }
   }

}

class TttModel {
   public static final int ROWS = 3;
   public static final int COLS = ROWS;
   public static final String GRID_POSITION = "grid position";

   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);
   private TttPiece[][] tttGrid = new TttPiece[ROWS][COLS];
   private TttPiece player = TttPiece.X;
   private boolean gameOver;

   public TttModel() {
      clear();
   }

   public void setGridPosition(int row, int col, TttPiece piece)
         throws TttException {
      if (gameOver) {
         return;
      }
      if (tttGrid[row][col] == TttPiece.EMPTY) {
         tttGrid[row][col] = piece;
         checkForWin(row, col, piece);
         nextPlayer();
         pcSupport.firePropertyChange(GRID_POSITION, null, tttGrid);
      } else {
         String message = "Invalid setGridPosition for row: %d, col: %d, piece: %s. "
               + "Spot already occupied by piece: %s";
         message = String.format(message, row, col, piece, tttGrid[row][col]);
         throw new TttException(message);
      }
   }

   public TttPiece[][] getTttGrid() {
      return tttGrid;
   }

   public void gridPress(int row, int col) throws TttException {
      setGridPosition(row, col, player);
   }

   public void nextPlayer() {
      player = player == TttPiece.X ? TttPiece.O : TttPiece.X;
   }

   private void checkForWin(int row, int col, TttPiece piece) {
      // TODO finish

   }

   public void clear() {
      for (int row = 0; row < tttGrid.length; row++) {
         for (int col = 0; col < tttGrid[row].length; col++) {
            tttGrid[row][col] = TttPiece.EMPTY;
         }
      }
      player = TttPiece.X;
      pcSupport.firePropertyChange(GRID_POSITION, null, tttGrid);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

}

@SuppressWarnings("serial")
class TttException extends Exception {

   public TttException() {
      super();
   }

   public TttException(String message) {
      super(message);
   }

}