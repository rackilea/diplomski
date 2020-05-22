private void initComponents() {

    urlPanel = new javax.swing.JPanel();
    urlLabel = new javax.swing.JLabel();
    urlField = new javax.swing.JTextField();
    urlButton = new javax.swing.JButton();
    tabbedPane = new javax.swing.JTabbedPane();
    tab1 = new javax.swing.JPanel();
    tab2 = new javax.swing.JPanel();
    tab3 = new javax.swing.JPanel();
    tableScrollPane = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    mainMenu = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    aboutMenu = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

    urlPanel.setLayout(new java.awt.BorderLayout());

    urlLabel.setText("url:");
    urlPanel.add(urlLabel, java.awt.BorderLayout.WEST);

    urlField.setText("http://google.com");
    urlPanel.add(urlField, java.awt.BorderLayout.CENTER);

    urlButton.setText("Go");
    urlPanel.add(urlButton, java.awt.BorderLayout.EAST);

    getContentPane().add(urlPanel);

    javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
    tab1.setLayout(tab1Layout);
    tab1Layout.setHorizontalGroup(
        tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 395, Short.MAX_VALUE)
    );
    tab1Layout.setVerticalGroup(
        tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 32, Short.MAX_VALUE)
    );

    tabbedPane.addTab("tab1", tab1);

    javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
    tab2.setLayout(tab2Layout);
    tab2Layout.setHorizontalGroup(
        tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 395, Short.MAX_VALUE)
    );
    tab2Layout.setVerticalGroup(
        tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 32, Short.MAX_VALUE)
    );

    tabbedPane.addTab("tab2", tab2);

    javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
    tab3.setLayout(tab3Layout);
    tab3Layout.setHorizontalGroup(
        tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 395, Short.MAX_VALUE)
    );
    tab3Layout.setVerticalGroup(
        tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 32, Short.MAX_VALUE)
    );

    tabbedPane.addTab("tab3", tab3);

    getContentPane().add(tabbedPane);

    tableScrollPane.setViewportView(table);

    getContentPane().add(tableScrollPane);

    fileMenu.setText("File");
    mainMenu.add(fileMenu);

    aboutMenu.setText("About");
    mainMenu.add(aboutMenu);

    setJMenuBar(mainMenu);

    pack();
}