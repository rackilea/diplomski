nextJButton.setText("next >");
  nextJButton.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
        nextJButtonActionPerformed(evt);
     }
  });

  JPanel panel = new JPanel();
  panel.add(numberJLabel);
  panel.add(numberJTextField);
  panel.add(otherJTextField);
  panel.add(nextJButton);

  getContentPane().add(panel);

  pack();
}// </editor-fold>//GEN-END:initComponents