public MyFrame(){
 JFrame temp = new JFrame;
 temp.pack();
 Insets insets = temp.getInsets();
 temp = null;
 this.setSize(new Dimension(insets.left + insets.right + 500,
             insets.top + insets.bottom + 500));
 this.setVisible(true);
 this.setResizable(false);
}