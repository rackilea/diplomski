private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    jPanel1.setVisible(false);
    NewJFrame.container.remove(NewJPanel.this);
    NewJPanel1 p=new NewJPanel1();
    NewJFrame.container.add(p);

    p.initFocus();
}