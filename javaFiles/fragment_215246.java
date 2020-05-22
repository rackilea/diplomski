JPanel searchPanel = new JPanel(new GridBagLayout()) {
        Dimension minSize = new Dimension(200, 0);

        @Override
        public Dimension getMinimumSize() {
            return minSize;
        }
    };
    searchPanel.setBorder(BorderFactory.createTitledBorder("Search query"));
    GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
            GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
            new Insets(5, 2, 5, 3), 0, 0);
    searchPanel.add(new JLabel("1"), gbc);
    gbc.gridx = 1;
    gbc.gridwidth = 3;
    gbc.weightx = 1;
    searchPanel.add(new JTextField(), gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.weightx = 0;
    searchPanel.add(new JLabel("1"), gbc);
    gbc.gridx = 1;
    gbc.weightx = 1;
    searchPanel.add(new JTextField(), gbc);
    gbc.gridx = 2;
    gbc.weightx = 0;
    searchPanel.add(new JLabel("1"), gbc);
    gbc.gridx = 3;
    gbc.weightx = 1;
    searchPanel.add(new JTextField(), gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.weightx = 0;
    searchPanel.add(new JLabel("1"), gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 3;
    gbc.weightx = 1;
    searchPanel.add(new JTextField(), gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.weightx = 0;
    searchPanel.add(new JLabel("1"), gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weightx = 1;
    searchPanel.add(new JTextField(), gbc);
    gbc.gridx = 2;
    gbc.weightx = 0;
    searchPanel.add(new JLabel("1"), gbc);
    gbc.gridx = 3;
    gbc.weightx = 1;
    searchPanel.add(new JTextField(), gbc);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.PAGE_END;
    gbc.weighty = 1.0;
    gbc.ipadx = 2;
    gbc.ipady = 2;
    gbc.insets = new Insets(15, 0, 0, 0);
    gbc.weightx = 0;
    searchPanel.add(new JButton("b"), gbc);
    return searchPanel;