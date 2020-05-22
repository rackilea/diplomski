import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MineCellGrid extends JPanel {
   private MineCellGridModel model;
   private List<MineCell> mineCells = new ArrayList<MineCell>();

   public MineCellGrid(final int maxRows, final int maxCols, int mineNumber) {
      model = new MineCellGridModel(maxRows, maxCols, mineNumber);
      setLayout(new GridLayout(maxRows, maxCols));

      for (int row = 0; row < maxRows; row++) {
         for (int col = 0; col < maxCols; col++) {
            MineCell mineCell = new MineCell(row, col);
            add(mineCell);
            mineCells.add(mineCell);
            model.add(mineCell.getModel(), row, col);
         }
      }

      reset();
   }

   public void reset() {
      model.reset();
      for (MineCell mineCell : mineCells) {
         mineCell.reset();
      }
   }
}