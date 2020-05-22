public TestHide(java.awt.Frame parent, boolean modal) {
super(parent, modal);
setIconImage(Toolkit.getDefaultToolkit().getImage("images\\white_title.png"));
initComponents();
jPanel2.setVisible(false);
pack();  }