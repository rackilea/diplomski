boolean allSelected = true;
for(Component component : myPanel.getComponents()) {
  if(component instanceof JCheckBox) {
    allSelected &= ((JCheckBox)component).isSelected();
  }
}