public Drawing() {
    final RPanel rPanel = new RPanel();
    setSize(1180, 750);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new MyComponent());

    JPanel glassPane = (JPanel) getGlassPane();
    glassPane.setLayout(new BorderLayout());
    glassPane.add(rPanel, BorderLayout.CENTER);
    glassPane.setVisible(true); 

    setVisible(true);

    // ...