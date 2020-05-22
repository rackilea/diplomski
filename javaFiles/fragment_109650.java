public Game() {
    try {
        JFrame frame = new JFrame();
        image = ImageIO.read(new File("Zombatar.jpg"));

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.getContentPane().add(this);
        this.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tittle - Game");

        addKeyListener(new KeyInputHandler());

        //this is important to intercept key events
        setFocusable(true);
        requestFocusInWindow();

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}