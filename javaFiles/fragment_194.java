ListCellRenderer renderer = comboBox.getRenderer();

Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
BasicComboPopup popup = (BasicComboPopup)child;
JList list = popup.getList();

ListModel model = combobox.getModel();   
for(int i = 0; i < model.getSize(); i++) 
{
    Object value = model.getElementAt(i);
    JLabel label = (JLabel)renderer.getListCellRendererComponent(list, value, i, false, false);
    components.add( label.getText() );
}