public static void main(String[] args) {

    JFrame Frame = new JFrame();
    JTabbedPane jTabbedPane1 = new javax.swing.JTabbedPane();
    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JPanel jPanel1 = new javax.swing.JPanel();
    JButton jButton1 = new javax.swing.JButton();
    JButton jButton2 = new javax.swing.JButton();
    JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
    JTable jTable1 = new javax.swing.JTable();

    Frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

    jButton1.setText("jButton1");
    jPanel1.add(jButton1);

    jButton2.setText("jButton2");
    jPanel1.add(jButton2);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},

            },
            new String[]{
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
    ));
    jScrollPane2.setViewportView(jTable1);

    jPanel1.add(jScrollPane2);

    jScrollPane1.setViewportView(jPanel1);

    jTabbedPane1.addTab("tab2", jScrollPane1);

    Frame.setContentPane(jTabbedPane1);
    Frame.setVisible(true);
}