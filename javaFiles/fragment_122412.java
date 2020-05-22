public class GamePanel extends JPanel implements ActionListener, KeyListener {

    public Game game;
    public Player player;

    public GamePanel(Game game) {
        setBackground(Color.GREEN);
        this.game = game;
        addKeyListener(this);
        setFocusable(true);
    }

    public void init() {
        player = new Player(game, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, game.getWidth() - 36);
        repaint();
    }
    //...
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (player != null) {
            player.paint(g);
        }
    }
}