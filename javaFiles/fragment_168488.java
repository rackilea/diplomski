import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableContextMenuDemo {

    @SuppressWarnings("serial")
    private JTable createTableWithRandomData(int tableNumber) {
        String[] cols = { "col 1", "col 2", "col 3" };
        JTable table = new JTable(new DefaultTableModel(getRandomData(10,
                cols.length), cols)) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(200, 150);
            }
        };
        ClearFuncs action1 = new ClearFuncs(tableNumber, table);
        SayHelloAction action2 = new SayHelloAction();
        JPopupMenu popupMenu = createPopupMenu(action1, action2);
        PopupAdapter listener = new PopupAdapter(popupMenu);
        table.addMouseListener(listener);
        return table;
    }

    class SayHelloAction extends AbstractAction {
        public SayHelloAction() {
            putValue(NAME, "Hello");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello World");

        }
    }

    private Integer[][] getRandomData(int rows, int cols) {
        Random random = new Random();
        Integer[][] data = new Integer[rows][cols];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(Integer.MAX_VALUE);
            }
        }
        return data;
    }

    private JPopupMenu createPopupMenu(Action... actions) {
        JPopupMenu menu = new JPopupMenu();
        for (Action a : actions) {
            menu.add(a);
        }
        return menu;
    }

    class PopupAdapter extends MouseAdapter {
        JPopupMenu popupMenu;

        public PopupAdapter(final JPopupMenu popupMenu) {
            this.popupMenu = popupMenu;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.isPopupTrigger()) {
                highlightRow(e);
                doPopup(e);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                highlightRow(e);
                doPopup(e);
            }
        }

        protected void doPopup(MouseEvent e) {
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }

        protected void highlightRow(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point point = e.getPoint();
            int row = table.rowAtPoint(point);
            int col = table.columnAtPoint(point);

            table.setRowSelectionInterval(row, row);
            table.setColumnSelectionInterval(col, col);
        }

    }

    class ClearFuncs extends AbstractAction {
        int num;

        private JTable table;

        public ClearFuncs(int num, JTable table) {
            this.num = num;
            this.table = table;
            putValue(NAME, "Clear");
        }

        public ClearFuncs(int num) {
            this.num = num;
            putValue(NAME, "Clear");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row = " + row + ", col = " + col + ", table: " + num);
            table.setValueAt("", row, col);
        }
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        for (int i = 1; i <= 3; i++) {
            JTable table = createTableWithRandomData(i);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane
                    .setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            frame.add(scrollPane);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableContextMenuDemo().createAndShowGui();
            }
        });
    }
}