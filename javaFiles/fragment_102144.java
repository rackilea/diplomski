private JPanel createGridBagPanel() {
    JPanel gridBagPanel = new JPanel(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.insets = new Insets(10, 10, 10, 10);

    String[] headers = {"Header 1", "Header 2", "etc..."};
    String[][] data = {{"Some data", "some more data", "etc..."},
            {"Some data 1", "some more data 3", "etc..."},
            {"Some data 2", "some more data 4", "etc..."}};

    JTable table = new JTable(data, headers);
    JScrollPane scrollableTable = new JScrollPane(table);
    scrollableTable.setMinimumSize(new Dimension(400, 400));
    scrollableTable.setPreferredSize(new Dimension(500, 500));
    scrollableTable.setMaximumSize(new Dimension(800, 800));

    // Nasty work around to support min and max size
    // https://stackoverflow.com/questions/15161332/setting-up-a-maximum-component-size-when-using-gridbaglayout-in-java
    JPanel wrappingPanel = new JPanel(null);
    wrappingPanel.setLayout(new BoxLayout(wrappingPanel, BoxLayout.LINE_AXIS));
    wrappingPanel.add(scrollableTable);

    gridBagPanel.add(wrappingPanel, constraints);

    return gridBagPanel;
}