GridBagConstraints gridBagConstraints;

    panel = new JPanel();
    findLabel = new javax.swing.JLabel();
    findField = new javax.swing.JTextField();
    replaceLabel = new javax.swing.JLabel();
    replaceField = new javax.swing.JTextField();
    replaceAllButton = new javax.swing.JButton();
    replaceButton = new javax.swing.JButton();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    panel.setLayout(new GridBagLayout());

    findLabel.setText("Find :");
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.ipadx = 94;
    gridBagConstraints.ipady = 30;
    panel.add(findLabel, gridBagConstraints);
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.ipadx = 149;
    panel.add(findField, gridBagConstraints);

    replaceLabel.setText("Replace With :");
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.ipadx = 34;
    gridBagConstraints.ipady = 23;
    panel.add(replaceLabel, gridBagConstraints);
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.ipadx = 149;
    panel.add(replaceField, gridBagConstraints);

    replaceAllButton.setText("Find And Replace All");
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipady = 9;
    panel.add(replaceAllButton, gridBagConstraints);

    replaceButton.setText("Replace");
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 99;
    gridBagConstraints.ipady = 8;
    panel.add(replaceButton, gridBagConstraints);
    //adding panel to the jframe
    getContentPane().add(panel, BorderLayout.CENTER);

    pack();