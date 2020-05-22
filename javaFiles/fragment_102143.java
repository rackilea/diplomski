// Not recommended
private JPanel createNullPanel() {
    JPanel nullPanel = new JPanel(null);

    String[] headers = {"Header 1", "Header 2", "etc..."};
    String[][] data = {{"Some data", "some more data", "etc..."},
            {"Some data 1", "some more data 3", "etc..."},
            {"Some data 2", "some more data 4", "etc..."}};

    JTable table = new JTable(data, headers);
    JScrollPane scrollableTable = new JScrollPane(table);

    scrollableTable.setMinimumSize(new Dimension(100, 100));
    scrollableTable.setMaximumSize(new Dimension(500, 500));

    JButton minButton = new JButton("Min");
    minButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            scrollableTable.setSize(scrollableTable.getMinimumSize());
        }
    });
    minButton.setBounds(10, 10, 50, 25);
    nullPanel.add(minButton);


    JButton maxButton = new JButton("Min");
    maxButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            scrollableTable.setSize(scrollableTable.getMaximumSize());
        }
    });
    maxButton.setBounds(70, 10, 50, 25);
    nullPanel.add(maxButton);

    nullPanel.add(scrollableTable);
    scrollableTable.setBounds(10, 45, 300, 300);

    return nullPanel;
}