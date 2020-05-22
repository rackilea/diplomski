import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;

public class TableWithTimer {

    private JFrame frame = new JFrame();
    private JScrollPane scroll = new JScrollPane();
    private JTable myTable;
    private String[] columnNames = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
        "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private String[] rowNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z"};
    private Object[][] compoundNames = new String[26][25];
    private int count = 1;
    private javax.swing.Timer timer = null;

    public TableWithTimer() {
        myTable = new JTable(compoundNames, columnNames);
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        myTable.setPreferredScrollableViewportSize(new Dimension(400, 300));
        myTable.setShowHorizontalLines(true);
        myTable.setShowVerticalLines(true);
        scroll.setViewportView(myTable);
        frame.add(scroll, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
        start();
    }

    private void start() {
        timer = new javax.swing.Timer(2500, updateCol());
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("updating row " + (count + 1));
                TableModel model = myTable.getModel();
                int row = model.getRowCount() - 1;// -1 == leave the cell empty at [0, 0]
                for (int j = 0; j < row; j++) {
                    myTable.changeSelection(row, 0, false, false);
                    Object value = rowNames[j];
                    model.setValueAt(value, count, 0);
                    count++;
                    if (count >= myTable.getRowCount()) {
                        myTable.changeSelection(0, 0, false, false);
                        timer.stop();
                        System.out.println("update cycle completed");
                        myTable.clearSelection();
                    }
                }
            }
        };
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                //System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        TableWithTimer tableWithTimer = new TableWithTimer();
    }
}