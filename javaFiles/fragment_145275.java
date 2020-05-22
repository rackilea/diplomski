import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TestTable {

    public class RadioButtonCellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

        private JRadioButton radioButton;

        public RadioButtonCellEditorRenderer() {
            this.radioButton = new JRadioButton();
            radioButton.addActionListener(this);
            radioButton.setOpaque(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            radioButton.setSelected(Boolean.TRUE.equals(value));
            return radioButton;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            radioButton.setSelected(Boolean.TRUE.equals(value));
            return radioButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopCellEditing();
        }

        @Override
        public Object getCellEditorValue() {
            return radioButton.isSelected();
        }

    }

    private JFrame f;
    private JTable table;

    private class MyObjectManager {
        private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
        private List<MyObject> objects = new ArrayList<TestTable.MyObject>();

        public void addObject(MyObject object) {
            objects.add(object);
            object.setManager(this);
            propertyChangeSupport.firePropertyChange("objects", null, object);
        }

        public List<MyObject> getObjects() {
            return objects;
        }

        public void setAsSelected(MyObject myObject) {
            for (MyObject o : objects) {
                o.setSelected(myObject == o);
            }
        }
    }

    private class MyObject {
        private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

        private MyObjectManager manager;

        private String value;

        private boolean selected;

        public MyObject(String value) {
            this.value = value;
        }

        public PropertyChangeSupport getPropertyChangeSupport() {
            return propertyChangeSupport;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
            propertyChangeSupport.firePropertyChange("value", null, value);
        }

        public MyObjectManager getManager() {
            return manager;
        }

        public void setManager(MyObjectManager manager) {
            this.manager = manager;
            propertyChangeSupport.firePropertyChange("manager", null, manager);
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            if (this.selected != selected) {
                this.selected = selected;
                if (selected) {
                    manager.setAsSelected(this);
                }
                propertyChangeSupport.firePropertyChange("selected", !selected, selected);
            }
        }

    }

    protected void initUI() {
        MyObjectManager manager = new MyObjectManager();
        for (int i = 0; i < 200; i++) {
            MyObject object = new MyObject("Row " + (i + 1));
            manager.addObject(object);
        }
        table = new JTable(new MyTableModel(manager));
        table.setRowHeight(20);
        TableColumn column = table.getColumnModel().getColumn(1);
        column.setCellEditor(new RadioButtonCellEditorRenderer());
        column.setCellRenderer(new RadioButtonCellEditorRenderer());
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(table), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

    }

    public class MyTableModel extends AbstractTableModel implements PropertyChangeListener {

        private final MyObjectManager manager;

        public MyTableModel(MyObjectManager manager) {
            super();
            this.manager = manager;
            manager.propertyChangeSupport.addPropertyChangeListener(this);
            for (MyObject object : manager.getObjects()) {
                object.getPropertyChangeSupport().addPropertyChangeListener(this);
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getSource() == manager) {
                // OK, not the cleanest thing, just to get the gist of it.
                if (evt.getPropertyName().equals("objects")) {
                    ((MyObject) evt.getNewValue()).getPropertyChangeSupport().addPropertyChangeListener(this);
                }
                fireTableDataChanged();
            } else if (evt.getSource() instanceof MyObject) {
                int index = manager.getObjects().indexOf(evt.getSource());
                fireTableRowsUpdated(index, index);
            }
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return manager.getObjects().size();
        }

        public MyObject getValueAt(int row) {
            return manager.getObjects().get(row);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return getValueAt(rowIndex).getValue();
            case 1:
                return getValueAt(rowIndex).isSelected();
            }
            return null;
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            if (columnIndex == 1) {
                getValueAt(rowIndex).setSelected(Boolean.TRUE.equals(value));
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
            case 0:
                return "Value";
            case 1:
                return "Selected";
            }
            return null;
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

}