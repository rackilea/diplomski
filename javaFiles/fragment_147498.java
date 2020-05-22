import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class TetrisTable {

    public static void main(String[] args) {
        new TetrisTable();
    }

    public TetrisTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTable table;
        private TetrisTabelModel model;
        private int currentRow = 0;
        private int blockHeight = 3;
        private int blockWidth = 3;

        public TestPane() {
            model = new TetrisTabelModel();
            table = new JTable(model);
            table.setDefaultRenderer(Integer.class, new TetrisTabelCellRenderer());
            table.setRowHeight(24);
            Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
            while (columns.hasMoreElements()) {
                TableColumn column = columns.nextElement();
                column.setPreferredWidth(24);
                column.setMinWidth(24);
                column.setMaxWidth(24);
                column.setWidth(24);
            }
            setLayout(new GridBagLayout());
            add(table);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int col = (model.getColumnCount() - blockWidth) / 2;
                    int row = currentRow - blockHeight;
                    if (row + blockHeight >= model.getRowCount()) {
                        ((Timer) e.getSource()).stop();
                    } else {
                        drawShape(row, col, 0);
                        currentRow++;
                        row = currentRow - blockHeight;
                        drawShape(row, col, 3);
                    }

                }

                public void drawShape(int row, int col, int color) {

                    for (int index = 0; index < blockHeight; index++) {

                        if (row >= 0 && row < model.getRowCount()) {

                            switch (index) {
                                case 0:
                                case 1:
                                    model.setValueAt(color, row, col);
                                    break;
                                case 2:
                                    model.setValueAt(color, row, col);
                                    model.setValueAt(color, row, col + 1);
                                    model.setValueAt(color, row, col + 2);
                                    break;
                            }

                        }
                        row++;

                    }
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

        }
    }

    public class TetrisTabelModel extends AbstractTableModel {

        private int[][] values;

        public TetrisTabelModel() {
            values = new int[20][10];
        }

        @Override
        public int getRowCount() {
            return values.length;
        }

        @Override
        public int getColumnCount() {
            return values[0].length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Integer.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return values[rowIndex][columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            values[rowIndex][columnIndex] = (int) aValue;
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    public class TetrisTabelCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, "", false, false, row, column);
            setOpaque(true);
            if (value != null) {
                if (value == 0) {
                    setBackground(Color.WHITE);
                } else if (value == 1) {
                    setBackground(Color.RED);
                } else if (value == 2) {
                    setBackground(Color.GREEN);
                } else if (value == 3) {
                    setBackground(Color.BLUE);
                } else if (value == 4) {
                    setBackground(Color.YELLOW);
                }
            } else {
                setBackground(Color.DARK_GRAY);
            }
            return this;
        }
    }
}