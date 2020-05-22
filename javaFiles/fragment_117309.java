import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Random;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ThreadMonitorExample {

    public static void main(String[] args) {
        new ThreadMonitorExample();
    }

    public ThreadMonitorExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                ThreadTableModel model = new ThreadTableModel();
                model.add(new Task(0, model));
                model.add(new Task(1, model));
                model.add(new Task(2, model));
                model.add(new Task(3, model));
                model.add(new Task(4, model));
                JTable table = new JTable(model);

                TaskProgressRenderer progressRenderer = new TaskProgressRenderer();
                TaskStatusRenderer statusRenderer = new TaskStatusRenderer();
                table.getColumnModel().getColumn(1).setCellRenderer(progressRenderer);
                table.getColumnModel().getColumn(2).setCellRenderer(statusRenderer);
                table.getColumnModel().getColumn(2).setCellEditor(new TaskStatusEditor());

                table.setRowHeight(
                                Math.max(getCellRendererHeight(table, 0, 1, progressRenderer), 
                                getCellRendererHeight(table, 0, 2, statusRenderer)));

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected int getCellRendererHeight(JTable table, int row, int column, TableCellRenderer renderer) {
        return renderer.getTableCellRendererComponent(table, table.getValueAt(row, column), true, true, row, column).getPreferredSize().height;
    }

    public class ThreadTableModel extends AbstractTableModel {

        private String[] headers = {"ID", "Progress", "Action"};
        private List<Task> tasks;

        public ThreadTableModel() {
            tasks = new ArrayList<>(25);
        }

        public void add(Task task) {
            int row = getRowCount();
            tasks.add(task);
            fireTableRowsInserted(row, getRowCount() - 1);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 2 && !tasks.get(rowIndex).isRunning() && !tasks.get(rowIndex).isDone();
        }

        @Override
        public int getRowCount() {
            return tasks.size();
        }

        @Override
        public int getColumnCount() {
            return headers.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = Object.class;
            switch (columnIndex) {
                case 0:
                    clazz = String.class;
                    break;
                case 1:
                    clazz = Integer.class;
                    break;
            }
            return clazz;
        }

        @Override
        public String getColumnName(int column) {
            return headers[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Task task = tasks.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = task.getID();
                    break;
                case 1:
                    value = task.getProgress();
                    break;
                case 2:
                    value = task;
                    break;
            }
            return value;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            System.out.println("setValueAt " + rowIndex + "x" + columnIndex);
            if (columnIndex == 2) {
                Task task = tasks.get(rowIndex);
                if (!task.isRunning() && !task.isDone()) {
                    task.execute();
                    fireTableCellUpdated(rowIndex, columnIndex);
                }
            }
        }

        public void updated(Task task) {
            int row = tasks.indexOf(task);
            System.out.println("Row updated " + row);
            fireTableRowsUpdated(row, row);
        }
    }

    public class TaskProgressRenderer extends JProgressBar implements TableCellRenderer {

        public TaskProgressRenderer() {
            setOpaque(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Integer) {
                int progress = (int) value;
                System.out.println("cellProgress = " + progress);
                setValue(progress);
            }
            if (isSelected) {
                setBackground(table.getSelectionBackground());
                setOpaque(true);
            } else {
                setBackground(table.getBackground());
                setOpaque(false);
            }
            return this;
        }

    }

    public class TaskStatusEditor extends AbstractCellEditor implements TableCellEditor {

        private JPanel editor;

        public TaskStatusEditor() {
            editor = new JPanel();
            editor.add(new JButton("Start"));
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    stopCellEditing();
                }
            });
            return editor;
        }

    }

    public class TaskStatusRenderer extends JPanel implements TableCellRenderer {

        private JButton start;
        private JLabel label;

        public TaskStatusRenderer() {
            setOpaque(false);
            start = new JButton("Start");
            label = new JLabel();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            removeAll();
            if (value instanceof Task) {
                Task task = (Task) value;
                if (task.isDone()) {
                    try {
                        label.setText(task.get());
                    } catch (Exception ex) {
                        label.setText(ex.getMessage());
                    }
                    add(label);
                } else if (task.isRunning()) {
                    label.setText("Working");
                    add(label);
                } else {
                    add(start);
                }
            }
            if (isSelected) {
                setBackground(table.getSelectionBackground());
                setOpaque(true);
            } else {
                setBackground(table.getBackground());
                setOpaque(false);
            }
            return this;
        }

    }

    public class Task extends SwingWorker<String, Object> {

        private int id;
        private String threadResult;
        private ThreadTableModel tableModel;
        private boolean running;

        public Task(int id, ThreadTableModel tableModel) {
            this.tableModel = tableModel;
            this.id = id;
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    System.out.println(e.getPropertyName());
                    if ("state".equalsIgnoreCase(e.getPropertyName())
                                    && "DONE".equalsIgnoreCase(e.getNewValue().toString())) {
                        try {
                            threadResult = (String)get();
                        } catch (Exception ignore) {
                            ignore.printStackTrace();
                        }
                    }

                    if ("progress".equalsIgnoreCase(e.getPropertyName())) {
                        System.out.println("task.getProgress = " + getProgress());
                        Task.this.tableModel.updated(Task.this);
                    }
                }
            });
        }

        public boolean isRunning() {
            return running;
        }

        public int getID() {
            return id;
        }

        @Override
        protected String doInBackground() throws Exception {
            running = true;
            setProgress(0);
            int prog = 0;
            Random rand = new Random(42);
            while (prog < 100) {
                prog += Math.abs(rand.nextInt() % 5);
                Thread.sleep(250);
                setProgress(Math.min(prog, 100));
            }
            return "42";
        }
    }
}