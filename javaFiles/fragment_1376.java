import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class HexText extends JFrame {
  public static void main(String... args) {
    final HexText window = new HexText();

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        window.setVisible(true);
      }
    });
  }

  private static class HexTableModel extends AbstractTableModel {
    List<Integer> data = new ArrayList<>();

    @Override
    public int getRowCount() {
      return data.size();
    }

    @Override
    public int getColumnCount() {
      return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      if (columnIndex == 0) {
        return Integer.toHexString(rowIndex << 5);
      } else {
        int row = data.get(rowIndex);
        int theByte = 0xFF & (row >> (columnIndex * 2));
        String output = Integer.toHexString(theByte);
        if (output.length() == 1)
          output = "0" + output;
        return output;
      }
    }

    public void addRow(int rowElement) {
      data.add(rowElement);

      fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
  }

  public HexText() {
    JPanel contentPane = new JPanel(new BorderLayout());

    HexTableModel theModel = new HexTableModel();

    JTable theTable = new JTable(theModel);

    Random r = new Random();

    for (int i = 0; i < 20; i++) {
      theModel.addRow(r.nextInt());
    }

    contentPane.add(theTable, BorderLayout.CENTER);
    this.add(theTable);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
  }
}