JScrollPane scrollPane = new JScrollPane(table);
// Force the scrollbars to always be displayed
scrollPane.setHorizontalScrollBarPolicy(
    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
scrollPane.setVerticalScrollBarPolicy(
    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 


GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
groupLayout.setHorizontalGroup(
    groupLayout.createParallelGroup(Alignment.TRAILING)
    .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
      .addContainerGap()
      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)