public EditUsers() {
    super("User Modifications");
    //I removed some not GUI operations

    EU = getContentPane();

    buildUserInfoPanel();
    buildOutputPanel();
    buildButtonPanel();
    EU.add(modUsers, BorderLayout.NORTH);
    EU.add(output, BorderLayout.CENTER);
    EU.add(button, BorderLayout.SOUTH);
    pack();
    //put setLocationRelativeTo before setVisible() 
    setLocationRelativeTo(null);
    setVisible(true);
}