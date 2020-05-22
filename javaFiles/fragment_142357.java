public class Tetris extends JFrame
{
    public static final int height = 20; //height of a square
    public static final int width = 20; //width of a square
    public static final int x = 0;

    private GamePanel gamePanel;

    public static void main(String[] args)
    {
        Tetris tet = new Tetris();
        // Normally you would tie this to a button or some other user-triggered action.
        tet.gamePanel.start();
        tet.gamePanel.addPiece(new GamePiece(width, height, x));
    }

    public Tetris()
    {
        getContentPane().setLayout(new BorderLayout());
        gamePanel = GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        setSize(220,440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

public class GamePanel extends JPanel
{
    private List<GamePiece> moving;
    private List<GamePiece> still;
    private Timer timer;

    public GamePanel()
    {
        moving = new ArrayList<>();
        still = new ArrayList<>();
        timer = new Timer(100, new TimerListener());
    }

    public addPiece(int width, int height, int x)
    {
        moving.add(new GamePiece(width, height, x));
    }

    public void start()
    {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Rectangle clip = g.getClipBounds(null);
        Rectangle rectToDraw = new Rectangle();

        // I prefer this, but you can make the call every
        // time you call `GamePiece.getY()`
        long time = System.currentTimeMillis();

        for(GamePiece piece : this.moving) {
            rectToDraw.setSize(piece.width, piece.height)
            rectToDraw.setLocation(piece.x, piece.getY(time))
            if(rectangleToDraw.intersects(clip))
                ((Graphics2D)g).fill(rectToDraw)
        }

        for(GamePiece piece : this.still) {
            rectToDraw.setSize(piece.width, piece.height)
            rectToDraw.setLocation(piece.x, piece.getY(time))
            if(rectangleToDraw.intersects(clip))
                ((Graphics2D)g).fill(rectToDraw)
        }
    }

    private class TimerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            long time = System.currentTimeMillis();
            // Using non-iterator loop to move the pieces that
            // stopped safely. Iterator would crash on in-loop move.
            for(int i = 0; i < moving.size(); i++) {
                piece = moving.get(i);
                if(piece.getY(time) > 440 - piece.height) {
                    moving.remove(i);
                    still.add(piece);
                    i--;
                }
            }
            repaint();
        }
    }
}

public class GamePiece
{
    public final int width;
    public final int height;
    public final long startTime;
    public int x;

    public GamePiece(int width, int height, int x)
    {
        this.width = width;
        this.height = height;
        this.startTime = System.currentTimeMillis();
        this.x = x;
    }

    public int getY(long time)
    {
        // This hard-codes a velocity of 10px/sec. You could
        // implement a more complex relationship with time here.
        return (int)((time - this.startTime) / 100.0);
    }
}