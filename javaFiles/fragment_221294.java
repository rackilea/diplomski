import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TestFileTable {

    public class DirectoryModel extends AbstractTableModel {

        private File directory;

        private File[] files;

        public DirectoryModel(File directory) {
            super();
            setDiretory(directory);
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
            case 0:
                return "";
            case 1:
                return "File name";
            case 2:
                return "";
            default:
                break;
            }
            return "";
        }

        @Override
        public int getRowCount() {
            return files.length;
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex > 1;// button columns
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return FileSystemView.getFileSystemView().getSystemIcon(files[rowIndex]);
            case 1:
                return files[rowIndex].getName();
            case 2:
                return "Edit";
            case 3:
                return "Results";
            case 4:
                return "Take";
            case 5:
                return "Delete";
            }
            return null;
        }

        public TableModel setDiretory(File currentDirectory) {
            this.directory = currentDirectory;
            files = directory.listFiles();
            if (files == null) {
                files = new File[0];
            }
            Arrays.sort(files);
            fireTableDataChanged();
            return this;
        }

    }

    protected void initUI() {
        JFrame frame = new JFrame(TestFileTable.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTable table = new JTable();
        final JFileChooser fileChooser = new JFileChooser();
        final DirectoryModel model = new DirectoryModel(fileChooser.getCurrentDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY, new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                table.setModel(model.setDiretory(fileChooser.getCurrentDirectory()));
            }
        });
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(10, 10));
        table.setRowHeight(30);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof Icon) {
                    setText(null);
                    setIcon((Icon) value);
                } else {
                    super.setValue(value);
                }
            }
        });
        columnModel.getColumn(0).setPreferredWidth(36);
        columnModel.getColumn(0).setMaxWidth(36);
        table.setTableHeader(null);

        // If you don't have the class ButtonCOlumn, comment the next lines, it still works
        // You can get it at http://tips4java.wordpress.com/2009/07/12/table-button-column/
        new ButtonColumn(table, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(table, "You have chosen to edit " + table.getModel().getValueAt(table.getSelectedRow(), 1));
            }
        }, 2);
        new ButtonColumn(table, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(table,
                        "You have chosen to show results for " + table.getModel().getValueAt(table.getSelectedRow(), 1));
            }
        }, 3);
        new ButtonColumn(table, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(table, "You have chosen to take " + table.getModel().getValueAt(table.getSelectedRow(), 1));
            }
        }, 4);
        new ButtonColumn(table, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(table, "You have chosen to delete " + table.getModel().getValueAt(table.getSelectedRow(), 1));
            }
        }, 5);

        frame.add(fileChooser, BorderLayout.WEST);
        frame.add(new JScrollPane(table));
        frame.setSize(1200, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestFileTable().initUI();
            }
        });
    }
}