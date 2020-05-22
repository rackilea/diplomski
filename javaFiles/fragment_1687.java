jButton1.setText("posBar");
jButton1.setSize(jButton1.getPreferredSize()); // required if using null layout
JPanel jButton1Panel = new JPanel(); // added
jButton1Panel.setLayout(null); // generally frowned upon
jButton1Panel.setPreferredSize(jButton1.getPreferredSize()); // so wrapper is same size as JButton
jButton1Panel.add(jButton1); // add button to wrapper

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addComponent(jButton1Panel)  // ******* note change!! *******
        .addContainerGap(23, Short.MAX_VALUE))
);
jPanel2Layout.setVerticalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(38, 38, 38)
        .addComponent(jButton1Panel)  // ******* note change!! *******
        .addContainerGap(37, Short.MAX_VALUE))
);