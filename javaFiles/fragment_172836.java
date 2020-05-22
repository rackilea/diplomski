@Override
public void valueChanged(ListSelectionEvent e) {
    // otherList.clearSelection();
    if (e.getValueIsAdjusting()) {
        otherList.clearSelection();
    }
}