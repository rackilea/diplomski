public SimpleFlashExample_1() {
    // 1...
    initComponents();
    JFlashPlayer flashPlayer = new JFlashPlayer();
    flashPlayer.load(getClass(), "/clientserver/fl.swf");
    // 3...
    add(flashPlayer, BorderLayout.CENTER);
}

private void initComponents() {
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    // 2....
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 675, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 475, Short.MAX_VALUE)
    );

    pack();
}