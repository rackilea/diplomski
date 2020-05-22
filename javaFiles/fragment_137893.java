JPanel panel = new JPanel(new MigLayout("fillx","[right][][][]"));
panel.add(new JLabel("Very long label:"), "");
panel.add(new JTextField(20), "wrap");
panel.add(new JLabel("Short 1:"), "");
panel.add(new JTextField(20));
panel.add(new JLabel("Short 2:"), "");
panel.add(new JTextField(10), "");