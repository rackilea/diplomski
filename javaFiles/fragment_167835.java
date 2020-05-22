package tableselection;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableSelection extends JFrame {
    private static final long serialVersionUID = 1L;
    String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };
    Object[][] data = { { "Kathy", "Smith", "Snowboarding", Integer.valueOf(5), Boolean.valueOf(false) },
            { "John", "Doe", "Rowing", Integer.valueOf(3), Boolean.valueOf(true) },
            { "Sue", "Black", "Knitting", Integer.valueOf(2), Boolean.valueOf(false) },
            { "Jane", "White", "Speed reading", Integer.valueOf(20), Boolean.valueOf(true) },
            { "Joe", "Brown", "Pool", Integer.valueOf(10), Boolean.valueOf(false) } };

    public TableSelection() {
        JPanel main = new JPanel();
        JTable table = new JTable(data, columnNames) {
            private static final long serialVersionUID = 1L;
            List<Point> selected = new ArrayList<Point>();
            @Override protected void processMouseEvent(MouseEvent e) {
                if(e.getID() != MouseEvent.MOUSE_PRESSED)
                    return;
                int row = ((JTable)e.getSource()).rowAtPoint(e.getPoint());
                int col = ((JTable)e.getSource()).columnAtPoint(e.getPoint());
                if(row >= 0 && col >= 0) {
                    Point p = new Point(row, col);
                    if(selected.contains(p))
                        selected.remove(p);
                    else
                        selected.add(p);
                }
                ((JTable)e.getSource()).repaint();
            }

            @Override public boolean isCellSelected(int arg0, int arg1) {
                return selected.contains(new Point(arg0, arg1));
            }
        };
        JScrollPane pane = new JScrollPane(table);
        main.add(pane);
        this.add(main);

        this.setSize(800, 600);
        this.setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TableSelection();
    }

}