tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(446, 50, 397, 490);
    tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    tabbedPane.setFont(new Font("Carlito", Font.PLAIN, 13));
    tabbedPane.setBackground(Color.WHITE);
    frame.getContentPane().add(tabbedPane);  // JFrame

    tableMainTest = new JTable();
    tableMainTest.setName("tableMainTest");
    tableMainTest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableMainTest.setFont(new Font("Carlito", Font.PLAIN, 13));
    tableMainTest.setFocusable(false);
    tableMainTest.setModel(tableModel);

    tableMainTest.setPreferredScrollableViewportSize(tableMainTest.getPreferredSize());
    tableMainTest.changeSelection(0, 0, false, false);
    tableMainTest.setAutoCreateRowSorter(true);

    JScrollPane scrollMain = new JScrollPane(tableMainTest);
    scrollMain.add(tableMainTest.getTableHeader());
    scrollMain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
    scrollMain.setBounds(446, 50, 397, 490);

    tabbedPane.addTab(descrTableMain, scrollMain);