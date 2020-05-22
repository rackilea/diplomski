class CustomRenderer extends DefaultTableCellRenderer {

     public void setValue(Object value) 
     {
         setText("- "+value);
      }
  }

class MyCellEditor extends AbstractCellEditor
                         implements TableCellEditor,
                                    FocusListener,
                                    ActionListener
{
    JTextField textFeild;
    String currentValue;

    JTable table;
    int row, col;
    public MyCellEditor(JTable table) {
        this.table = table;
        textFeild = new JTextField();
        textFeild.addActionListener(this);
        textFeild.addFocusListener(this);
    }


    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        currentValue = (String)value;
        return textFeild;

    }

    @Override
    public void focusGained(FocusEvent e) {
        textFeild.setText("");
        row = table.getSelectedRow();
        col = table.getSelectedColumn();

    }

    @Override
    public void focusLost(FocusEvent e) {

        if(!textFeild.getText().equals(""))
           //currentValue = textFeild.getText();
           table.setValueAt(textFeild.getText(), row, col);

        fireEditingStopped();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(!textFeild.getText().trim().equals(""))
           currentValue = textFeild.getText();
       fireEditingStopped();
    }


}