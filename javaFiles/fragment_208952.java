JPanel panelPunts = new JPanel();
    panelPunts.setLayout(new GridBagLayout());
    panelPunts.setBackground(Color.GRAY);

    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = 0;
    gc.gridy = 0;
    gc.anchor = GridBagConstraints.NORTH;
    gc.insets = new Insets(5, 5, 5, 5);

    JLabel titol = new JLabel();
    titol.setText("<html><h1><u> Points</u></h1></html>");
    panelPunts.add(titol, gc);

    gc.gridy = 1;
    JLabel etnia1 = new JLabel();
    etnia1.setText("Team A: 20");
    panelPunts.add(etnia1, gc);

    gc.gridy = 2;
    JLabel etnia2 = new JLabel();
    etnia2.setText("Team A: 10");
    panelPunts.add(etnia2, gc);