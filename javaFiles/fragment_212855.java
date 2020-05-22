JPanel global = new JPanel();
    global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
    global.setPreferredSize(new Dimension(500, 312));
    global.setSize(500, 312);
    global.setBounds(8, 5, 500, 312);
    global.setBorder(BorderFactory.createLineBorder(Color.black));
    global.setBackground(Color.white);
    // Elements of global

    JLabel label1 = new JLabel("Global Settings");
    label1.setAlignmentX(Component.CENTER_ALIGNMENT);
    label1.setFont(new Font("tahoma", Font.BOLD, 17));
    global.add(label1);
    JSeparator sep = new JSeparator();
    sep.setMaximumSize(new Dimension((int) sep.getMaximumSize().getWidth(), 50));
    global.add(sep);

    // Name Field
    JPanel c = new JPanel();
    c.setMaximumSize(new Dimension((int) c.getMaximumSize().getWidth(), 50));
    JLabel label = new JLabel("Display Name");
    JTextField text = new JTextField(20);
    text.setPreferredSize(new Dimension(20, 25));
    c.add(label);
    c.add(text);
    global.add(c);

    // Hostname Field
    JPanel c1 = new JPanel();
    c1.setMaximumSize(new Dimension((int) c1.getMaximumSize().getWidth(), 50));
    JLabel label2 = new JLabel("Host Name");
    JTextField text1 = new JTextField(20);
    text1.setPreferredSize(new Dimension(20, 25));
    c1.add(label2);
    c1.add(text1);
    global.add(c1);
    global.add(Box.createVerticalGlue());