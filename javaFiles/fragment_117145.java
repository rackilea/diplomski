public void actionPerformed(ActionEvent e) {
    //myCellRenderer.setShowSelected(true);
    for (int i = 0; i < cellSelectionSet.getSize(); i++) {
        cellSelectionSet.getElementAt(i).setNewlySelected(false);
    }
    table.repaint();
}