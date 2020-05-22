package SwingWorkerExampleCopy;

import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class SwingWorkerExampleCopy {
  public static void main(String[] args) {
    // Show GUI
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        GUI gui = new GUI();

        DefaultTableModel tableModel = new DefaultTableModel();

        // Use a SwingWorker
        Worker worker = new Worker(tableModel);
        worker.execute();

        JTable table = new JTable(tableModel);
        table.setEnabled(false);
        // table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);
        gui.getContentPane()
          .add(scrollPane, BorderLayout.CENTER);

      }
    });
  }
}

class GUI extends JFrame {
  private static final long serialVersionUID = 1L;

  public GUI() {
    setTitle("GUI");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 350, 400);
    setLocationRelativeTo(null);
    setVisible(true);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
    contentPane.setLayout(new BorderLayout(0, 0));

    setContentPane(contentPane);
  }
}

class Worker extends SwingWorker<DefaultTableModel, Object[]> {

  private final static int  numRows = 10;
  private final static int  numCols = 10;

  private DefaultTableModel model;

  Worker(DefaultTableModel model) {
    this.model = model;
    model.setColumnCount(numCols);
  }

  @Override
  protected DefaultTableModel doInBackground() throws Exception {
    // Add row
    for (int row = 0; row < numRows; row++) {
      // Build columns
      for (int col = 0; col < numCols; col++) {
        if (col == 0) {
          publish(new Object[] { new String("Row " + row), row,
            col });
        } else {
          // Simulate a slow source
          Thread
            .sleep(new Random().nextInt((250 - 50) + 1) + 50);

          Boolean isSuccessful = false;

          // Simulate a return value
          if (new Random().nextBoolean()) {
            isSuccessful = true;
          }

          publish(new Object[] {
            new String((isSuccessful == true ? "x" : "o")), row,
            col });

          if (isSuccessful == true) {
            break;
          }
        }
      }
    }

    return model;
  }

  @Override
  protected void process(List<Object[]> chunks) {
    for (Object[] chunk : chunks) {
      // chunk[0]: cell value
      // chunk[1]: number
      // chunk[2]: column
      if ((int) chunk[2] == 0) {
        Object[] row = new Object[numCols];
        row[0] = (Object) chunk[0];
        model.addRow(row);
      } else {
        model.setValueAt((Object) chunk[0], (int) chunk[1],
          (int) chunk[2]);
      }
    }
  }
}