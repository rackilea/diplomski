public static class GamePanel extends JPanel implements ActionListener, KeyListener {

    public final static int WIDTH = 700, HEIGHT = 450;

    public Game game;
    public Player player;

    public GamePanel(Game game) {
        setBackground(Color.GREEN);
        this.game = game;
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }