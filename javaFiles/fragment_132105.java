int selection = displayUnitListPane.getSelectedIndex();
link.storePrerequisite( selection );

JOptionPane.showMessageDialog( frame , "Now please select where you want the unit you just selected to be a prequisite" );

displayUnitListPane.clearSelection();
link.addPrerequisite ( selection );