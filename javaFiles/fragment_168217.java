import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SudokuTest {

    public static void main(String[] args) {
        new SudokuTest();
    }

    public SudokuTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(new SudokuTable()));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SudokuTable extends JTable {

        public SudokuTable() {
            super(new DefaultTableModel(9, 9));
            setDefaultRenderer(Object.class, new SudokuCellRender());
        }

    }

    public class SudokuCellRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            int left = 0;
            int top = 0;
            int right = 0;
            int bottom = 0;

            if ((column % 3) == 0) {
                left = 2;
            } else if ((column % 3) == 2) {
                right = 2;
            }

            if ((row % 3) == 0) {
                top = 2;
            }
            if ((row % 3) == 2) {
                bottom = 2;
            }

            setBorder(new MatteBorder(top, left, bottom, right, Color.RED));

            return this;
        }

    }

}