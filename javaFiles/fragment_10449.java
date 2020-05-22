import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTable table;
        private SearchTermTableModel model;

        public TestPane() {
            model = new SearchTermTableModel();
            model.add(new SearchTerm(false, "Bananas"));
            model.add(new SearchTerm(false, "Apples"));
            model.add(new SearchTerm(false, "Streberries"));
            model.add(new SearchTerm(false, "Poines with guns"));
            model.add(new SearchTerm(false, "Anime"));
            model.add(new SearchTerm(false, "Helicopters"));
            model.add(new SearchTerm(false, "Sunny beaches which I'm not on"));

            setLayout(new BorderLayout());
            table = new JTable(model);
            add(new JScrollPane(table));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class SearchTerm {

        private boolean selected;
        private String text;

        public SearchTerm(boolean selected, String text) {
            this.selected = selected;
            this.text = text;
        }

        public boolean isSelected() {
            return selected;
        }

        public String getText() {
            return text;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public class SearchTermTableModel extends AbstractTableModel {

        private List<SearchTerm> searchTerms;

        public SearchTermTableModel() {
            searchTerms = new ArrayList<>(25);
        }

        public void add(SearchTerm searchTerm) {
            searchTerms.add(searchTerm);
            fireTableRowsInserted(searchTerms.size() - 1, searchTerms.size() - 1);
        }

        @Override
        public int getRowCount() {
            return searchTerms.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int column) {
            return column == 0 ? "" : "Search Term";
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 0 ? Boolean.class : String.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            SearchTerm term = searchTerms.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = term.isSelected();
                    break;
                case 1:
                    value = term.getText();
                    break;
            }
            return value;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 0;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    if (aValue instanceof Boolean) {
                        SearchTerm term = searchTerms.get(rowIndex);
                        term.setSelected((Boolean) aValue);
                        super.setValueAt(aValue, rowIndex, columnIndex);
                    }
                    break;
            }
        }
    }

}