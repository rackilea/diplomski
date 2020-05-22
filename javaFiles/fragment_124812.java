setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    JPanel layout = new JPanel(new GridLayout(0, 1));
    layout.add(new JButton("Settings"));
    layout.add(new JButton("Textures"));

    c.anchor = GridBagConstraints.CENTER;
    c.weighty = 1.0;
    c.gridy = 0;
    add(layout, c);

    c.gridy = 1;
    c.weighty = 0.1;
    c.anchor = GridBagConstraints.PAGE_END;
    add(new JButton("Back"), c);