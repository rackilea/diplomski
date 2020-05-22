JPanel panel = new JPanel(new MigLayout("fillx"));
panel.add(new JLabel("Very long label:"), "");
panel.add(new JTextField(20), "wrap");
panel.add(new JLabel("Short 1:"), "right");
panel.add(new JTextField(20));
panel.add(new JLabel("Short 2:"), "right");
panel.add(new JTextField(10), "wrap");