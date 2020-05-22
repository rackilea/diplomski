// in new selection model:
public void setSelectedIndex(int index) {
    // do pre-switch things here
    super.setSelectedIndex(index);
}

// in ViewPanel, on tabbedPane create:
tabbedPane.setModel(newSelectionModel);