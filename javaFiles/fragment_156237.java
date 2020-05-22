import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * DiceGame.java
 * previously called Greed2.java
 * http://stackoverflow.com/questions/17264671/why-is-my-swing-program-still-advancing
 * @author Pete
 * 6/24/2013
 */
public class DiceGame {

   private static void createAndShowGui() {
      DicePanel mainPanel = new DicePanel();

      JFrame frame = new JFrame("Dice Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
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

@SuppressWarnings("serial")
class DicePanel extends JPanel {
   private static final String FIRST_ROLL_STATUS_TEXT = "Please select die to re-roll and press Second Roll";
   private static final String RESET_STATUS_TEXT = "Please press the First Roll Button";
   private static final String SECOND_ROLL_STATUS_TEXT = "Please press the Reset Button";
   private Die[] dieArray = new Die[5];
   private GameState gameState = GameState.FIRST_ROLL;
   private JButton rollButton = new JButton();
   private JButton exitButton = new JButton();
   private JTextArea messageArea = new JTextArea(20, 60);
   private Map<GameState, Action> rollActionMap = new HashMap<>();
   private JLabel statusLabel = new JLabel("  ");

   public DicePanel() {
      rollActionMap.put(GameState.FIRST_ROLL, new RollAction(this, GameState.FIRST_ROLL));
      rollActionMap.put(GameState.SECOND_ROLL, new RollAction(this, GameState.SECOND_ROLL));
      rollActionMap.put(GameState.RESET, new RollAction(this, GameState.RESET));

      exitButton.setAction(new ExitAction());

      setLayout(new BorderLayout());
      int gap = 3;
      setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
      add(statusLabel, BorderLayout.NORTH);
      add(new JScrollPane(messageArea), BorderLayout.CENTER);
      add(createSouthPanel(), BorderLayout.SOUTH);

      setGameState(GameState.RESET);
      setGameState(GameState.FIRST_ROLL);
   }

   private JPanel createSouthPanel() {
      int gap = 20;
      JPanel diePanel = new JPanel(new GridLayout(1, 0, gap, gap));
      for (int i = 0; i < dieArray.length; i++) {
         dieArray[i] = new Die();
         diePanel.add(dieArray[i].getDieLabel());
      }

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 10, 10));
      buttonPanel.add(rollButton);
      buttonPanel.add(exitButton);
      JPanel southPanel = new JPanel(new BorderLayout());
      southPanel.add(diePanel, BorderLayout.CENTER);
      southPanel.add(buttonPanel, BorderLayout.SOUTH);
      return southPanel;
   }

   public GameState getGameState() {
      return gameState;
   }

   public void rollAll() {
      for (Die die : dieArray) {
         die.roll();
         die.setSelectable(true);
      }
   }

   public void rollSelected() {
      for (Die die : dieArray) {
         if (die.isSelected()) {
            die.roll();
         }
         die.setSelected(false);
         die.setSelectable(false);
      }
   }

   public void setGameState(GameState gameState) {
      GameState currentState = this.gameState;
      this.gameState = gameState;
      rollButton.setAction(rollActionMap.get(gameState));

      if (currentState == GameState.RESET) {
         reset();
      } else if (currentState == GameState.FIRST_ROLL) {
         firstRoll();
      } else if (currentState == GameState.SECOND_ROLL) {
         secondRoll();
      }
   }

   private void firstRoll() {
      rollAll();
      statusLabel.setText(FIRST_ROLL_STATUS_TEXT);
   }

   private void secondRoll() {
      rollSelected();

      // TODO: calculate score and display

      statusLabel.setText(SECOND_ROLL_STATUS_TEXT);
   }

   public void reset() {
      for (Die die : dieArray) {
         die.reset();
      }
      statusLabel.setText(RESET_STATUS_TEXT);
   }
}

@SuppressWarnings("serial")
class RollAction extends AbstractAction {
   private DicePanel dicePanel;

   public RollAction(DicePanel dicePanel, GameState gameState) {
      super(gameState.getText());
      this.dicePanel = dicePanel;
      putValue(MNEMONIC_KEY, gameState.getMnemonic());
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      dicePanel.setGameState(dicePanel.getGameState().next());
   }
}

@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
   private static final String EXIT = "Exit";

   public ExitAction() {
      super(EXIT);
      putValue(MNEMONIC_KEY, KeyEvent.VK_X);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Window win = SwingUtilities.getWindowAncestor(((Component)e.getSource()));
      win.dispose();
   }
}

enum GameState {
   FIRST_ROLL("First Roll", KeyEvent.VK_F), SECOND_ROLL("Second Roll", KeyEvent.VK_S), 
   RESET("Reset", KeyEvent.VK_R);

   private String text;
   private int mnemonic;

   private GameState(String text, int mnemonic) {
      this.text = text;
      this.mnemonic = mnemonic;
   }

   public int getMnemonic() {
      return mnemonic;
   }

   public String getText() {
      return text;
   }

   public GameState next() {
      int ordinal = ordinal();
      ordinal++;
      ordinal %= values().length;
      return values()[ordinal];
   }
}

class Die {
   private static final int BORDER_GAP = 3;
   private static final Border SELECTED_BORDER = 
         BorderFactory.createLineBorder(Color.red, BORDER_GAP);
   private static final Border UNSELECTED_BORDER = 
         BorderFactory.createEmptyBorder(BORDER_GAP, BORDER_GAP, BORDER_GAP, BORDER_GAP);

   private JLabel dieLabel = new JLabel();
   private Random random = new Random();
   private DieValue dieValue = DieValue.BLANK;
   private boolean selectable = false;
   private boolean selected = false;

   public Die() {
      reset();
      dieLabel.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent evt) {
            if (selectable) {
               setSelected(!selected);
            }
         }
      });
   }

   public Component getDieLabel() {
      return dieLabel;
   }

   public void setSelected(boolean selected) {
      this.selected = selected;
      Border border = selected ? SELECTED_BORDER : UNSELECTED_BORDER;
      dieLabel.setBorder(border);
   }

   public void roll() {
      int value = random.nextInt(6) + 1;
      dieValue = DieValue.getDieValue(value);
      dieLabel.setIcon(dieValue.getIcon());
   }

   public void reset() {
      dieValue = DieValue.BLANK;
      setSelected(false);
      setSelectable(false);
      dieLabel.setIcon(dieValue.getIcon());
   }

   public DieValue getValue() {
      return dieValue;
   }

   public boolean isSelected() {
      return selected;
   }

   public boolean isSelectable() {
      return selectable;
   }

   public void setSelectable(boolean selectable) {
      this.selectable = selectable;
   }
}

enum DieValue {
   BLANK(0, ""), 
   ONE(1, "One"), TWO(2, "Two"), THREE(3, "Three"), 
   FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six");

   private static final int OUT_FRAME = 110;
   private static final int ARC = 16;
   private static final float STROKE_WIDTH = 4f;
   private static final int SML_GAP = 2;
   private static final int OVAL_RADIUS = 24;
   private Icon icon;
   private String name;
   private int value;

   private DieValue(int value, String name) {
      this.value = value;
      this.name = name;
      this.icon = createIcon(value);
   }

   private Icon createIcon(int value) {
      BufferedImage img = new BufferedImage(OUT_FRAME, OUT_FRAME, 
            BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      Stroke stroke = new BasicStroke(STROKE_WIDTH);
      g2.setColor(Color.white);
      g2.fillRoundRect(0, 0, OUT_FRAME, OUT_FRAME, ARC, ARC);
      g2.setColor(Color.black);
      g2.setStroke(stroke);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.drawRoundRect(SML_GAP, SML_GAP, OUT_FRAME - SML_GAP * 2, 
            OUT_FRAME - SML_GAP * 2, ARC, ARC);


      g2.setColor(Color.black);
      switch (value) {
      case 1:
         fillOval(g2, 1, 1);
         break;
      case 2:
         fillOval(g2, 0, 0);
         fillOval(g2, 2, 2);
         break;
      case 3:
         fillOval(g2, 0, 0);
         fillOval(g2, 1, 1);
         fillOval(g2, 2, 2);
         break;
      case 4:
         fillOval(g2, 0, 0);
         fillOval(g2, 0, 2);
         fillOval(g2, 2, 0);
         fillOval(g2, 2, 2);
         break;
      case 5:
         fillOval(g2, 0, 0);
         fillOval(g2, 0, 2);
         fillOval(g2, 1, 1);
         fillOval(g2, 2, 0);
         fillOval(g2, 2, 2);
         break;
      case 6:
         fillOval(g2, 0, 0);
         fillOval(g2, 0, 1);
         fillOval(g2, 0, 2);
         fillOval(g2, 2, 0);
         fillOval(g2, 2, 1);
         fillOval(g2, 2, 2);
         break;

      default:
         break;
      }

      g2.dispose();
      return new ImageIcon(img);
   }

   private void fillOval(Graphics2D g2, int row, int col) {
      double rectWidth = OUT_FRAME - 4 * STROKE_WIDTH;
      int x = (int) (2 * STROKE_WIDTH - OVAL_RADIUS / 2 + (col + 0.5) * rectWidth / 3);
      int y = (int) (2 * STROKE_WIDTH - OVAL_RADIUS / 2 + (row + 0.5) * rectWidth / 3);

      g2.fillOval(x, y, OVAL_RADIUS, OVAL_RADIUS);
   }

   public static DieValue getDieValue(int value) {
      for (DieValue dieImage : DieValue.values()) {
         if (dieImage.getValue() == value) {
            return dieImage;
         }
      }
      return null;
   }

   public Icon getIcon() {
      return icon;
   }

   public String getName() {
      return name;
   }

   public int getValue() {
      return value;
   }

}