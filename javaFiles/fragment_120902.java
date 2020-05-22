MigLayout layout = new MigLayout("debug, fill", "[][][]");

    JPanel panel = new JPanel(layout);
    panel.add(new JButton("Button"));
    panel.add(new JButton("Button"));
    panel.add(new JButton("Button"), "spany 2, wrap");
    panel.add(new JButton("Button"));
    panel.add(new JButton("Button"));