import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

/**
 * http://stackoverflow.com/questions/7006029/minesweeper-action-events
 * 
 * @author Pete
 */
@SuppressWarnings("serial")
public class MineCell extends JPanel {
   private static final String LABEL = "label";
   private static final String BUTTON = "button";
   private static final int PS_WIDTH = 24;
   private static final int PS_HEIGHT = PS_WIDTH;
   private static final float LABEL_FONT_SIZE = (float) (24 * PS_WIDTH) / 30f;
   private static final float BUTTON_FONT_SIZE = (float) (14 * PS_WIDTH) / 30f;
   private JButton button = new JButton();
   private JLabel label = new JLabel(" ", SwingConstants.CENTER);
   private CardLayout cardLayout = new CardLayout();
   private MineCellModel model;

   public MineCell(final boolean mined, int row, int col) {
      model = new MineCellModel(mined, row, col);
      model.addPropertyChangeListener(new MyPCListener());
      label.setFont(label.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
      button.setFont(button.getFont().deriveFont(Font.PLAIN, BUTTON_FONT_SIZE));
      button.setMargin(new Insets(1, 1, 1, 1));
      setLayout(cardLayout);

      add(button, BUTTON);
      add(label, LABEL);

      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pressedAction();
         }
      });
      button.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
               model.upDateButtonFlag();
            }
         }
      });
   }

   public MineCell(int row, int col) {
      this(false, row, col);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PS_WIDTH, PS_HEIGHT);
   }

   public void pressedAction() {
      if (model.isFlagged()) {
         return;
      }
      model.pressedAction();
   }

   public void showCard(String cardConstant) {
      cardLayout.show(this, cardConstant);
   }

   // TODO: have this change the button's icon
   public void setFlag(boolean flag) {
      if (flag) {
         button.setBackground(Color.yellow);
         button.setForeground(Color.red);
         button.setText("f");
      } else {
         button.setBackground(null);
         button.setForeground(null);
         button.setText("");
      }
   }

   private void setMineBlown(boolean mineBlown) {
      if (mineBlown) {
         label.setBackground(Color.red);
         label.setOpaque(true);
         showCard(LABEL);
      } else {
         label.setBackground(null);
      }
   }

   public MineCellModel getModel() {
      return model;
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      model.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      model.removePropertyChangeListener(listener);
   }

   private class MyPCListener implements PropertyChangeListener {
      public void propertyChange(PropertyChangeEvent evt) {
         String propName = evt.getPropertyName();
         if (propName.equals(MineCellModel.MINE_BLOWN)) {
            setMineBlown(true);
         } else if (propName.equals(MineCellModel.FLAG_CHANGE)) {
            setFlag(model.isFlagged());
         } else if (propName.equals(MineCellModel.BUTTON_PRESSED)) {
            if (model.isMineBlown()) {
               setMineBlown(true);
            } else {
               String labelText = (model.getValue() == 0) ? "" : String
                        .valueOf(model.getValue());
               label.setText(labelText);
            }
            showCard(LABEL);
         }
      }
   }

   public void reset() {
      setFlag(false);
      setMineBlown(false);
      showCard(BUTTON);
      label.setText("");
   }

}