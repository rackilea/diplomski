JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel content = new JPanel();
    content.add(new JLabel("A Label"));
    content.add(new JButton("A Button"));

    frame.add(content);
    frame.pack();
    frame.setVisible(true);