import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

class MineCellModel {
   public static final String FLAG_CHANGE = "Flag Change";
   public static final String BUTTON_PRESSED = "Button Pressed";
   public static final String MINE_BLOWN = "Mine Blown";
   private int row;
   private int col;
   private int value = 0;
   private boolean mined = false;;
   private boolean flagged = false;
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
            this);
   private boolean pressed = false;
   private boolean mineBlown = false;

   public MineCellModel(boolean mined, int row, int col) {
      this.mined = mined;
      this.row = row;
      this.col = col;
   }

   public void incrementValue() {
      int temp = value + 1;
      setValue(temp);
   }

   public void setValue(int value) {
      this.value = value;
   }

   public int getValue() {
      return value;
   }

   public void setMineBlown(boolean mineBlown) {
      this.mineBlown = mineBlown;
      PropertyChangeEvent evt = new PropertyChangeEvent(this, MINE_BLOWN, false, true);
      pcSupport.firePropertyChange(evt);
   }

   public boolean isMineBlown() {
      return mineBlown;
   }

   public void setMined(boolean mined) {
      this.mined = mined;
   }

   public void setFlagged(boolean flagged) {
      this.flagged = flagged;
   }

   public int getRow() {
      return row;
   }

   public int getCol() {
      return col;
   }

   public boolean isMined() {
      return mined;
   }

   public boolean isFlagged() {
      return flagged;
   }

   public void pressedAction() {
      if (pressed) {
         return;
      }
      pressed = true;
      if (mined) {
         setMineBlown(true);
      }

      PropertyChangeEvent evt = new PropertyChangeEvent(this, BUTTON_PRESSED,
               -1, value);
      pcSupport.firePropertyChange(evt);
   }

   public void upDateButtonFlag() {
      boolean oldValue = flagged;
      setFlagged(!flagged);
      PropertyChangeEvent evt = new PropertyChangeEvent(this, FLAG_CHANGE,
               oldValue, flagged);
      pcSupport.firePropertyChange(evt);
   }

   public void reset() {
      mined = false;
      flagged = false;
      pressed = false;
      mineBlown = false;
      value = 0;
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }
}