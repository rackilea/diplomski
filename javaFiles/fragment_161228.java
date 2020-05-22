JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.getContentPane().setLayout(new BorderLayout());
    JColorChooser colorChooser = new JColorChooser();
    AbstractColorChooserPanel hsvPanel = colorChooser.getChooserPanels()[1];
    frame.add(hsvPanel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);