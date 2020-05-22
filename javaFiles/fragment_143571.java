import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class SearchBox extends JPanel {

    private static final long serialVersionUID = 1L;
    private static JFrame frame = new JFrame();
    private JTextField editor;
    private JButton arrowButton;
    //private JToggleButton arrowButton;
    private JDialog popupWindow = new JDialog(frame);
    private Component userComponent;
    private JTable table;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private Object[] columnNames;
    private DefaultTableModel tableModel;
    private Object[][] sheetDataInString;

    public SearchBox() {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        editor = new JTextField();
        editor.setPreferredSize(new Dimension(250, 25));
        editor.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilter();
            }

            private void newFilter() {
                RowFilter<DefaultTableModel, Object> rowFilter = null;
                Document document = editor.getDocument();
                String filterText;
                try {
                    filterText = document.getText(0, document.getLength()).trim();
                    rowFilter = RowFilter.regexFilter("(?i)" + filterText);
                } catch (java.util.regex.PatternSyntaxException e) {
                    return;
                } catch (BadLocationException badLocationException) {
                    return;
                }
                rowSorter.setRowFilter(rowFilter);
                table.setRowSorter(rowSorter);
            }
        });
        initialize();
        addListeners();
        setBorders();
    }

    private void addListeners() {
        arrowButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!popupWindow.isVisible()) {
                    showWindow();
                } else {
                    hideWindow();
                }
            }
        });
    }

    protected void showWindow() {
        if (null != getWindowComponent()) {
            popupWindow.getContentPane().add(getWindowComponent());
            popupWindow.setLocation(new Point(SearchBox.this.getLocationOnScreen().x, SearchBox.this.getLocationOnScreen().y + 25));
            popupWindow.setUndecorated(true);
            popupWindow.setAlwaysOnTop(true);
            popupWindow.pack();
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    popupWindow.setVisible(true);
                }
            });
        }
    }

    protected void hideWindow() {
        popupWindow.setVisible(false);
    }

    private Component getWindowComponent() {
        return userComponent;
    }

    public void setWindowComponent(Component component) {
        userComponent = component;
    }

    private void initialize() {
        arrowButton = new BasicArrowButton(SwingConstants.SOUTH);//In my code there is an icon here
        arrowButton.setBorder(null);
        arrowButton.setContentAreaFilled(false);
    }

    private void setBorders() {
        add(editor);
        add(arrowButton);
        setBackground(editor.getBackground());
        setBorder(editor.getBorder());
        editor.setBorder(null);
    }

    public JTextField getTextComponent() {
        return editor;
    }

    public JButton getActionButton() {
        return arrowButton;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    protected static void createAndShowGUI() {
        JPanel panel = new JPanel();

        frame.setPreferredSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.add(new JLabel("Test Table Combo"));
        SearchBox searchBox = new SearchBox();
        searchBox.userComponent = searchBox.new SearchBoxTable();
        panel.add(searchBox);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class SearchBoxTable extends JScrollPane {

        private static final long serialVersionUID = 1L;

        public SearchBoxTable() {
            columnNames = new Object[]{"Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6"};
            sheetDataInString = new Object[21][6];
            for (int i = 0; i < sheetDataInString.length; i++) {
                for (int j = 0; j < 6; j++) {
                    sheetDataInString[i][j] = "Row Value : " + i + ", Column Value : " + j;
                }
            }

            tableModel = new DefaultTableModel(sheetDataInString, columnNames) {

                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };
            rowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
            table = new JTable(tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setAutoCreateRowSorter(true);
            table.setFillsViewportHeight(true);
            table.getTableHeader().setFont(new Font(null, Font.PLAIN, 13));
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            getViewport().add(table);
        }
    }
}