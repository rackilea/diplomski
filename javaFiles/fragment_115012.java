import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

/**
 * uses GroupLayout and Key Bindings
 * @link http://stackoverflow.com/questions/14784773/grouplayout-makes-action-listener-loses-focus
 * @author Pete
 *
 */
@SuppressWarnings("serial")
public class HelloWorldSwing2GroupLayout extends JPanel {
   private JLabel[] labels = {new JLabel("A"), new JLabel("B")};
   private Board2 board2 = new Board2();
   private JLabel directionLabel = new JLabel();

   public HelloWorldSwing2GroupLayout() {
      directionLabel.setHorizontalAlignment(SwingConstants.CENTER);
      board2.add(directionLabel);

      board2.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (Board2.DIRECTION.equals(pcEvt.getPropertyName())) {
               Direction dir = (Direction)pcEvt.getNewValue();
               if (dir != null) {
                  directionLabel.setText(dir.getText());
               } else {
                  directionLabel.setText("");
               }
            }
         }
      });

      GroupLayout layout = new GroupLayout(this);
      setLayout(layout);

      int lWidth = board2.getPreferredSize().width;
      int lHeight = board2.getPreferredSize().height / 2;
      Dimension preferredSize = new Dimension(lWidth, lHeight);
      for (JLabel label : labels) {
         label.setHorizontalAlignment(SwingConstants.CENTER);
         label.setVerticalAlignment(SwingConstants.CENTER);
         label.setBorder(BorderFactory.createLineBorder(Color.black));

         // please, please forgive me Jeanette! This is for demo purposes only.
         label.setPreferredSize(preferredSize);
      }

      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(labels[0], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(labels[1], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(board2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                  .addComponent(labels[0], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(labels[1], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(board2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)      
      );
   }

   private static void createAndShowGui() {
      HelloWorldSwing2GroupLayout mainPanel = new HelloWorldSwing2GroupLayout();

      JFrame frame = new JFrame("HelloWorldSwing2");
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

@SuppressWarnings("serial")
class Board2 extends JPanel {
   private static final int PREF_W = 200;
   private static final int PREF_H = 400;
   public static final String DIRECTION = "direction";
   private Direction direction = null;

   public Board2() {
      setBorder(BorderFactory.createTitledBorder("Board2"));
      InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
      ActionMap actionMap = getActionMap();

      for (Direction dir : Direction.values()) {
         inputMap.put(dir.getKeyStroke(), dir.getText());
         actionMap.put(dir.getText(), new MyArrowBinding(dir));
      }
   }

   private class MyArrowBinding extends AbstractAction {
      private Direction dir;

      public MyArrowBinding(Direction dir) {
         super(dir.getText());
         this.dir = dir;
         putValue(ACTION_COMMAND_KEY, dir);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setDirection(dir);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void setDirection(Direction direction) {
      Direction oldValue = this.direction;
      Direction newValue = direction;
      this.direction = newValue;

      firePropertyChange(DIRECTION, oldValue, newValue);
   }

   public Direction getDirection() {
      return direction;
   }
}

enum Direction {
   UP("Up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0)),
   DOWN("Down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0)),
   LEFT("Left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0)),
   RIGHT("Right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));

   Direction(String text, KeyStroke keyStroke) {
      this.text = text;
      this.keyStroke = keyStroke;
   }
   private String text;
   private KeyStroke keyStroke;

   public String getText() {
      return text;
   }

   public KeyStroke getKeyStroke() {
      return keyStroke;
   }

   @Override
   public String toString() {
      return text;
   }
}