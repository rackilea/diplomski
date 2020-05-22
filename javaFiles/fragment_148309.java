class MyComboBoxModel extends AbstractListModel implements ComboBoxModel {   
  String[] ComputerComps = { "Monitor", "Key Board", "Mouse", "Joy Stick", 
                 "Modem", "CD ROM", "RAM Chip", "Diskette" };

  String selection = null;

  public Object getElementAt(int index) {
    return ComputerComps[index];   
  }

  public int getSize() {
    return ComputerComps.length;   
  }

  public void setSelectedItem(Object anItem) {
    selection = (String) anItem; // to select and register an   
  } // item from the pull-down list

  // Methods implemented from the interface ComboBoxModel   
  public Object getSelectedItem() {
       return selection; // to add the selection to the combo box   
  } 
}