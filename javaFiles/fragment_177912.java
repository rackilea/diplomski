import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AnimationWithKeyBinding {
   @SuppressWarnings("serial")
   private static void createAndShowUI() {

      final JPanel cardPanel = new JPanel(new CardLayout()); 
      MenuPanel menuPanel = new MenuPanel();
      AnimationPanel animationPanel = new AnimationPanel();

      cardPanel.add(menuPanel, "Menu");
      cardPanel.add(animationPanel, "Animation");

      menuPanel.setNextBtnAction(new AbstractAction("Next") {
         {
            putValue(NAME, "Next");
            putValue(MNEMONIC_KEY, KeyEvent.VK_N);
         }
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ((CardLayout)cardPanel.getLayout()).next(cardPanel);
         }
      });

      JFrame frame = new JFrame("Animation With Key Binding");
      frame.getContentPane().add(cardPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

@SuppressWarnings("serial")
class MenuPanel extends JPanel {
   private JButton nextBtn = new JButton();

   public MenuPanel() {
      TitledBorder titledBorder = BorderFactory.createTitledBorder("Menu Panel");
      titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD, 24));
      setBorder(titledBorder);
      setLayout(new GridBagLayout());
      add(nextBtn);
   }

   public void setNextBtnAction(Action action) {
      nextBtn.setAction(action);
   }
}

@SuppressWarnings("serial")
class AnimationPanel extends JPanel {
   public static final int SPRITE_WIDTH = 20;
   public static final int PANEL_WIDTH = 400;
   public static final int PANEL_HEIGHT = 400;
   private static final int MAX_MSTATE = 25;
   private static final int SPIN_TIMER_PERIOD = 16;
   private static final int SPRITE_STEP = 3;

   private int mState = 0;
   private int mX = (PANEL_WIDTH - SPRITE_WIDTH) / 2;
   private int mY = (PANEL_HEIGHT - SPRITE_WIDTH) / 2;
   private int oldMX = mX;
   private int oldMY = mY;
   private boolean moved = false;

   // an array of sprite images that are drawn sequentially
   private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];

   public AnimationPanel() {
      // create and start the main animation timer
      new Timer(SPIN_TIMER_PERIOD, new SpinTimerListener()).start();
      setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      setBackground(Color.white);
      createSprites(); // create the images
      setupKeyBinding();
   }

   private void setupKeyBinding() {
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inMap = getInputMap(condition);
      ActionMap actMap = getActionMap();

      // this uses an enum of Direction that holds ints for the arrow keys
      for (Direction direction : Direction.values()) {
         int key = direction.getKey();
         String name = direction.name();

         // add the key bindings for arrow key and shift-arrow key
         inMap.put(KeyStroke.getKeyStroke(key, 0), name);
         inMap.put(KeyStroke.getKeyStroke(key, InputEvent.SHIFT_DOWN_MASK),
               name);
         actMap.put(name, new MyKeyAction(this, direction));
      }
   }

   // create a bunch of buffered images and place into an array,
   // to be displayed sequentially
   private void createSprites() {
      for (int i = 0; i < spriteImages.length; i++) {
         spriteImages[i] = new BufferedImage(SPRITE_WIDTH, SPRITE_WIDTH,
               BufferedImage.TYPE_INT_ARGB);
         Graphics2D g2 = spriteImages[i].createGraphics();
         g2.setColor(Color.red);
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         double theta = i * Math.PI / (2 * spriteImages.length);
         double x = SPRITE_WIDTH * Math.abs(Math.cos(theta)) / 2.0;
         double y = SPRITE_WIDTH * Math.abs(Math.sin(theta)) / 2.0;
         int x1 = (int) ((SPRITE_WIDTH / 2.0) - x);
         int y1 = (int) ((SPRITE_WIDTH / 2.0) - y);
         int x2 = (int) ((SPRITE_WIDTH / 2.0) + x);
         int y2 = (int) ((SPRITE_WIDTH / 2.0) + y);
         g2.drawLine(x1, y1, x2, y2);
         g2.drawLine(y1, x2, y2, x1);
         g2.dispose();
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(spriteImages[mState], mX, mY, null);
   }

   public void incrementX(boolean right) {
      oldMX = mX;
      if (right) {
         mX = Math.min(getWidth() - SPRITE_WIDTH, mX + SPRITE_STEP);
      } else {
         mX = Math.max(0, mX - SPRITE_STEP);
      }
      moved = true;
   }

   public void incrementY(boolean down) {
      oldMY = mY;
      if (down) {
         mY = Math.min(getHeight() - SPRITE_WIDTH, mY + SPRITE_STEP);
      } else {
         mY = Math.max(0, mY - SPRITE_STEP);
      }
      moved = true;
   }

   public void tick() {
      mState = (mState + 1) % MAX_MSTATE;
   }

   private class SpinTimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         tick();

         int delta = 20;
         int width = SPRITE_WIDTH + 2 * delta;
         int height = width;

         // make sure to erase the old image
         if (moved) {
            int x = oldMX - delta;
            int y = oldMY - delta;
            repaint(x, y, width, height);
         }

         int x = mX - delta;
         int y = mY - delta;

         // draw the new image
         repaint(x, y, width, height);
         moved = false;
      }
   }
}

enum Direction {
   UP(KeyEvent.VK_UP), DOWN(KeyEvent.VK_DOWN), LEFT(KeyEvent.VK_LEFT), RIGHT(
         KeyEvent.VK_RIGHT);

   private int key;

   private Direction(int key) {
      this.key = key;
   }

   public int getKey() {
      return key;
   }
}

// Actions for the key binding
@SuppressWarnings("serial")
class MyKeyAction extends AbstractAction {
   private AnimationPanel draw;
   private Direction direction;

   public MyKeyAction(AnimationPanel draw, Direction direction) {
      this.draw = draw;
      this.direction = direction;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      switch (direction) {
      case UP:
         draw.incrementY(false);
         break;
      case DOWN:
         draw.incrementY(true);
         break;
      case LEFT:
         draw.incrementX(false);
         break;
      case RIGHT:
         draw.incrementX(true);
         break;

      default:
         break;
      }
   }
}