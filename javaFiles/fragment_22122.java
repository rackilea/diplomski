public Main() {
    super("Clicker");

    addMouseListener(this);
    addKeyListener(this);

    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
}