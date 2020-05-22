import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableScrollTest extends JFrame {

    public TableScrollTest() {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"key", "value"}, 0);
        model.addRow(new Object[]{"short", "blah"});
        model.addRow(new Object[]{"long", "blah blah blah blah blah blah blah"});

        JTable table = new JTable(model) {
            private boolean trackViewportWidth = false;
            private boolean inited = false;
            private boolean ignoreUpdates = false;

            @Override
            protected void initializeLocalVars() {
                super.initializeLocalVars();
                inited = true;
                updateColumnWidth();
            }

            @Override
            public void addNotify() {
                super.addNotify();
                updateColumnWidth();
                getParent().addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        invalidate();
                    }
                });
            }

            @Override
            public void doLayout() {
                super.doLayout();
                if (!ignoreUpdates) {
                    updateColumnWidth();
                }
                ignoreUpdates = false;
            }

            protected void updateColumnWidth() {
                if (getParent() != null) {
                    int width = 0;
                    for (int col = 0; col < getColumnCount(); col++) {
                        int colWidth = 0;
                        for (int row = 0; row < getRowCount(); row++) {
                            int prefWidth = getCellRenderer(row, col).
                                    getTableCellRendererComponent(this, getValueAt(row, col), false, false, row, col).
                                    getPreferredSize().width;
                            colWidth = Math.max(colWidth, prefWidth + getIntercellSpacing().width);
                        }

                        TableColumn tc = getColumnModel().getColumn(convertColumnIndexToModel(col));
                        tc.setPreferredWidth(colWidth);
                        width += colWidth;
                    }

                    Container parent = getParent();
                    if (parent instanceof JViewport) {
                        parent = parent.getParent();
                    }

                    trackViewportWidth = width < parent.getWidth();
                }
            }

            @Override
            public void tableChanged(TableModelEvent e) {
                super.tableChanged(e);
                if (inited) {
                    updateColumnWidth();
                }
            }

            public boolean getScrollableTracksViewportWidth() {
                return trackViewportWidth;
            }

            @Override
            protected TableColumnModel createDefaultColumnModel() {
                TableColumnModel model = super.createDefaultColumnModel();
                model.addColumnModelListener(new TableColumnModelListener() {
                    @Override
                    public void columnAdded(TableColumnModelEvent e) {
                    }

                    @Override
                    public void columnRemoved(TableColumnModelEvent e) {
                    }

                    @Override
                    public void columnMoved(TableColumnModelEvent e) {
                        if (!ignoreUpdates) {
                            ignoreUpdates = true;
                            updateColumnWidth();
                        }
                    }

                    @Override
                    public void columnMarginChanged(ChangeEvent e) {
                        if (!ignoreUpdates) {
                            ignoreUpdates = true;
                            updateColumnWidth();
                        }
                    }

                    @Override
                    public void columnSelectionChanged(ListSelectionEvent e) {
                    }
                });
                return model;
            }
        };
        table.getColumn("key").setPreferredWidth(60);
//        table.getColumn("key").setMinWidth(60);
//        table.getColumn("key").setMaxWidth(60);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                TableScrollTest frame = new TableScrollTest();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(200, 200);
                frame.setResizable(true);
                frame.setVisible(true);
            }
        });
    }
}