public Window() {
    Container panel = this.getContentPane();
    panel.setLayout(new GridBagLayout());
    panel.setSize(1000,1000);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1;
    gbc.weighty = 1;

    gbc.gridy = 0; // First row

    JButton ordersButton = new JButton("Orders");
    gbc.gridx = 0;
    panel.add(ordersButton, gbc);

    JButton dishesButton = new JButton("Dishes");
    gbc.gridx = 1;
    panel.add(dishesButton, gbc);

    JButton ingredientsButton = new JButton("Ingredients");
    gbc.gridx = 2;
    panel.add(ingredientsButton, gbc);

    JButton suppliersButton = new JButton("Suppliers");
    gbc.gridx = 3;
    panel.add(suppliersButton, gbc);

    JButton staffButton = new JButton("Staff");
    gbc.gridx = 4;
    panel.add(staffButton, gbc);

    JButton dronesButton = new JButton("Drones");
    gbc.gridx = 5;
    panel.add(dronesButton, gbc);

    JButton usersButton = new JButton("Users");
    gbc.gridx = 6;
    panel.add(usersButton, gbc);

    JButton postcodesButton = new JButton("Postcodes");
    gbc.gridx = 7;
    panel.add(postcodesButton, gbc);

    JButton configurationButton = new JButton("Configuration");
    gbc.gridx = 8;
    panel.add(configurationButton, gbc);

    JTextField viewScreen = new JTextField();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 9;
    viewScreen.setPreferredSize(new Dimension(650, 200));
    viewScreen.setMinimumSize(new Dimension(650, 200));
    panel.add(viewScreen, gbc);
    gbc.gridwidth = 1;  // Reset the gridwidth

    // Third row
    JLabel orders1Label = new JLabel("order 1");
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(orders1Label, gbc);
    JLabel orders2Label = new JLabel("order 2");
    gbc.gridx = 1;
    gbc.gridy = 3;
    panel.add(orders2Label, gbc);
    JLabel dishes1Label = new JLabel("dish 1");
    gbc.gridx = 1;
    gbc.gridy = 4;
    panel.add(dishes1Label, gbc);
    JLabel dishes2Label = new JLabel("dish 2");
    gbc.gridx = 1;
    gbc.gridy = 5;
    panel.add(dishes2Label, gbc);

    gbc.gridwidth = 4; // Textfield width
    JTextField orders1TextField = new JTextField();
    gbc.gridx = 2;
    gbc.gridy = 2;
    panel.add(orders1TextField, gbc);
    JTextField orders2TextField = new JTextField();
    gbc.gridx = 2;
    gbc.gridy = 3;
    panel.add(orders2TextField, gbc);
    JTextField dishes1TextField = new JTextField();
    gbc.gridx = 2;
    gbc.gridy = 4;
    panel.add(dishes1TextField, gbc);
    JTextField dishes2TextField = new JTextField();
    gbc.gridx = 2;
    gbc.gridy = 5;
    panel.add(dishes2TextField, gbc); 

    orders1TextField.setPreferredSize(new Dimension(400, 20));
    orders2TextField.setPreferredSize(new Dimension(400, 20));
    dishes1TextField.setPreferredSize(new Dimension(400, 20));
    dishes2TextField.setPreferredSize(new Dimension(400, 20));

    //Display window
    setSize(800,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}