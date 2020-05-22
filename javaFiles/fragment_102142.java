private JPanel createMigPanel() {
    String layoutConstraints = "fillx, filly";
    String columnAndRowConstraints = "fill, grow, center";

    JPanel migPanel = new JPanel(new MigLayout(layoutConstraints, columnAndRowConstraints, columnAndRowConstraints));

    String[] headers = {"Header 1", "Header 2", "etc..."};
    String[][] data = {{"Some data", "some more data", "etc..."},
            {"Some data 1", "some more data 3", "etc..."},
            {"Some data 2", "some more data 4", "etc..."}};

    JTable table = new JTable(data, headers);
    JScrollPane scrollableTable = new JScrollPane(table);

    migPanel.add(new JScrollPane(table), "width 400:500:800, height 400:500:800");

    return migPanel;
}