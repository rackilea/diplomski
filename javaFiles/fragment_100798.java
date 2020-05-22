private void addAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {
    new AddAlbumPage().setVisible(true);
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = createImageIcon("images/middle.gif");
    ExamplePanel panel1 = new ExamplePanel("Album");
    tabbedPane.addTab("New Album", icon,panel1,"New Album"); 
}