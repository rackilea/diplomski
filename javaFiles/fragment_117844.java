private void initComponents() {

  // existing code

  this.setLayout(new BorderLayout());       
  JPanel topPanel=new JPanel();
  this.setLayout(new FlowLayout(java.awt.FlowLayout.CENTER, 15, 15));

  this.add(jLabel1);
  this.add(jLabel3);

  this.add(topPanel, BorderLayout.NORTH);
  this.add(jScrollPane2, BorderLayout.CENTER);
}