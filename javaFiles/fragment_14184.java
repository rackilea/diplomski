public SenzuView(){
    setLayout(new BorderLayout());
    ImageIcon image = new ImageIcon(getClass().getResource("res/senzu.jpg"));
    label = new JLabel(image);
    this.add(label, BorderLayout.CENTER);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true)
}