import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class MineCellGridModel {
   private MineCellModel[][] cellModelGrid;
   private List<Boolean> mineList = new ArrayList<Boolean>();
   private CellModelPropertyChangeListener cellModelPropChangeListener = new CellModelPropertyChangeListener();
   private int maxRows;
   private int maxCols;
   private int mineNumber;
   private int buttonsRemaining;

   public MineCellGridModel(final int maxRows, final int maxCols, int mineNumber) {
      this.maxRows = maxRows;
      this.maxCols = maxCols;
      this.mineNumber = mineNumber;
      for (int i = 0; i < maxRows * maxCols; i++) {
         mineList.add((i < mineNumber) ? true : false);
      }
      cellModelGrid = new MineCellModel[maxRows][maxCols];
      buttonsRemaining = (maxRows * maxCols) - mineNumber;
   }

   public void add(MineCellModel model, int row, int col) {
      cellModelGrid[row][col] = model;
      model.addPropertyChangeListener(cellModelPropChangeListener);
   }

   public void reset() {
      buttonsRemaining = (maxRows * maxCols) - mineNumber;

      // randomize the mine location
      Collections.shuffle(mineList);
      // reset the model grid and set mines
      for (int r = 0; r < cellModelGrid.length; r++) {
         for (int c = 0; c < cellModelGrid[r].length; c++) {
            cellModelGrid[r][c].reset();
            cellModelGrid[r][c].setMined(mineList.get(r
                     * cellModelGrid[r].length + c));
         }
      }
      // advance value property of all neighbors of a mined cell
      for (int r = 0; r < cellModelGrid.length; r++) {
         for (int c = 0; c < cellModelGrid[r].length; c++) {
            if (cellModelGrid[r][c].isMined()) {
               int rMin = Math.max(r - 1, 0);
               int cMin = Math.max(c - 1, 0);
               int rMax = Math.min(r + 1, cellModelGrid.length - 1);
               int cMax = Math.min(c + 1, cellModelGrid[r].length - 1);
               for (int row2 = rMin; row2 <= rMax; row2++) {
                  for (int col2 = cMin; col2 <= cMax; col2++) {
                     cellModelGrid[row2][col2].incrementValue();
                  }
               }
            }
         }
      }
   }

   private class CellModelPropertyChangeListener implements
            PropertyChangeListener {

      public void propertyChange(PropertyChangeEvent evt) {
         MineCellModel model = (MineCellModel) evt.getSource();
         int row = model.getRow();
         int col = model.getCol();

         if (evt.getPropertyName().equals(MineCellModel.BUTTON_PRESSED)) {
            if (cellModelGrid[row][col].isMineBlown()) {
               mineBlown();
            } else {
               buttonsRemaining--;
               if (buttonsRemaining <= 0) {
                  JOptionPane.showMessageDialog(null, "You've Won!!!", "Congratulations", JOptionPane.PLAIN_MESSAGE);
               }
               if (cellModelGrid[row][col].getValue() == 0) {
                  zeroValuePress(row, col);
               }
            }
         }
      }

      private void mineBlown() {
         for (int r = 0; r < cellModelGrid.length; r++) {
            for (int c = 0; c < cellModelGrid[r].length; c++) {
               MineCellModel model = cellModelGrid[r][c];
               if (model.isMined()) {
                  model.setMineBlown(true);
               }
            }
         }

      }

      private void zeroValuePress(int row, int col) {
         int rMin = Math.max(row - 1, 0);
         int cMin = Math.max(col - 1, 0);
         int rMax = Math.min(row + 1, cellModelGrid.length - 1);
         int cMax = Math.min(col + 1, cellModelGrid[row].length - 1);
         for (int row2 = rMin; row2 <= rMax; row2++) {
            for (int col2 = cMin; col2 <= cMax; col2++) {
               cellModelGrid[row2][col2].pressedAction();
            }
         }
      }
   }
}