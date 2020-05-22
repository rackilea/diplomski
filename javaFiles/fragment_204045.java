public class SharedModel extends AbstractTableModel
        implements ComboBoxModel, ListModel {
    private ComboBoxModel comboModel = new DefaultComboBoxModel();
    private ListModel listModel = new DefaultListModel();

    //ComboBoxModel
    @Override
    public void setSelectedItem(Object anItem) {
        comboModel.setSelectedItem(anItem);
    }

    @Override
    public Object getSelectedItem() {
        return comboModel.getSelectedItem();
    }

    // ListModel
    @Override
    public int getSize() {
        return listModel.getSize();
    }

    @Override
    public Object getElementAt(int index) {
        return listModel.getElementAt(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listModel.addListDataListener(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listModel.removeListDataListener(l);
    }

    // TableModel
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SharedModel sm = new SharedModel();
                JTable table = new JTable(sm);
                JList list = new JList(sm);
                JComboBox check = new JComboBox(sm);
            }
        });
    }
}