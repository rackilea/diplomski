JPanel panel = new JPanel(new GridBagLayout());
    JTextField sampleField = new JTextField(5);
    GridBagConstraints c = new GridBagConstraints();
    c.anchor = GridBagConstraints.WEST;
    c.gridx = 0;
    c.gridy = 0;
    c.insets = new Insets(5, 5, 5, 5);

    JLabel sampleLabel = new JLabel("sample text");
    panel.add(sampleLabel,c);

    c.gridy++;
    panel.add(sampleField,c);

    c.gridy++;
    panel.add(new JLabel("sample text 2"),c);

    c.gridy++;
    panel.add(new JTextField(5),c);

    c.gridy++;
    panel.add(new JTextField(5),c);