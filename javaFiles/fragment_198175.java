private void initItemsPanel() {
    JPanel itemsPanel = new JPanel();
    itemsPanel.setLayout(new FormLayout("left:pref, fill:400px, pref:grow", "fill:20px, fill:4px, fill:max(20px;pref)"));
    CellConstraints cc = new CellConstraints();

    // the left table
    JTable leftTable = new JTable();
    itemsPanel.add(leftTable.getTableHeader(), cc.xywh(1, 1, 1, 2));
    itemsPanel.add(leftTable, cc.xywh(1, 3, 1, 1));

    // the text pane
    itemsPanel.add(new JTextPane(), cc.xywh(2, 2, 1, 2));

    // the right table
    JTable rightTable = new JTable();
    rightTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    itemsPanel.add(rightTable.getTableHeader(), cc.xywh(3, 1, 1, 2));
    itemsPanel.add(rightTable, cc.xywh(3, 3, 1, 1));

    // Adding the items panel to dialog panel
    JScrollPane itemsScrollPane = new JScrollPane(itemsPanel);
    itemsScrollPane.getVerticalScrollBar().setUnitIncrement(3);

    dialogPanel.add(itemsScrollPane, BorderLayout.CENTER); // with dialogPanel previously instantiated
}