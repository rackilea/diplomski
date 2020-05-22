import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class ChangeCellColorDemo {

    private Random random = new Random();
    private JTable table = getTable();

    public ChangeCellColorDemo() {
        Timer timer = new Timer(2000, new TimerListener());
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                CurrentPrevious curPrev = (CurrentPrevious) model.getValueAt(i, 0);
                curPrev.setPrevious(curPrev.getCurrent());
                Double newCurrent = getRandomDouble();
                curPrev.setCurrent(newCurrent);
                model.setValueAt(curPrev, i, 0);
            }
        }
    }

    private JTable getTable() {
        JTable table = new JTable(getTableModel()) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component c = super.prepareRenderer(renderer, row, col);
                Object value = getValueAt(row, col);
                if (value instanceof CurrentPrevious) {
                    CurrentPrevious curPrev = (CurrentPrevious) value;
                    Double current = curPrev.getCurrent();
                    Double previous = curPrev.getPrevious();
                    Color color = getColor(current, previous);
                    c.setBackground(color);
                }
                return c;
            }

            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return getPreferredSize();
            }
        };
        return table;
    }

    private TableModel getTableModel() {
        String[] cols = {"Value"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < 10; i++) {
            Object[] row = new Object[1];
            Double current = getRandomDouble();
            Double previous = getRandomDouble();
            row[0] = new CurrentPrevious(current, previous);
            model.addRow(row);
        }
        System.out.println(model.getRowCount());
        return model;
    }

    private Color getColor(Double current, Double previous) {
        Color color;
        if (current.equals(previous) || current > previous) {
            color = Color.GREEN;
        } else {
            color = Color.RED;
        }
        return color;
    }

    private Double getRandomDouble() {
        BigDecimal bd = new BigDecimal(random.nextDouble());
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    class CurrentPrevious {

        Double current;
        Double previous;

        public CurrentPrevious() {}

        public CurrentPrevious(Double current, Double previous) {
            this.current = current;
            this.previous = previous;
        }

        public Double getCurrent() {
            return current;
        }

        public Double getPrevious() {
            return previous;
        }

        public void setCurrent(Double current) {
            this.current = current;
        }

        public void setPrevious(Double previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return current.toString();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChangeCellColorDemo();
            }
        });
    }
}