class Panel1 extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static final int DELAY = Frame1.DELAY;
    private Timer timer;
    private BufferedImage fighter;
    private BufferedImage background;
    int x, y;

    public Panel1() {
        timer = new Timer(DELAY, this);
        try {
            URL url = new URL(Frame1.SPRITE_IMAGE);
            // fighter = ImageIO.read(this.getClass().getResource("fighter.png"));
            fighter = ImageIO.read(url);

            url = new URL(Frame1.ANDROMEDA_IMAGE);
            background = ImageIO.read(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        initComponents();
        timer.start();
    }

    public void initComponents() {
        this.setSize(Frame1.WIDTH, Frame1.HEIGHT);
        this.setDoubleBuffered(true);
        this.setBackground(new Color(0, 0, 0, 0));
        x = 150;
        y = 200;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        g.drawImage(fighter, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.repaint();
    }

    public void moveLeft() {
        x -= 10;
    }

    public void moveRight() {
        x += 10;
    }
}