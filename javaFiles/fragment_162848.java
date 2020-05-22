setLayout(new GridBagLayout());
//
add(new JLabel("Password"), 
    new GridBagConstraints(0,0,1,1,1,1,
        GridBagConstraints.SOUTH,GridBagConstraints.NONE, 
        new Insets(3,3,3,3), 0,0));
field.setColumns(10);
add(field, new GridBagConstraints(0,1,1,1,1,1,
    GridBagConstraints.NORTH,GridBagConstraints.NONE, 
    new Insets(3,3,3,3), 0,0));