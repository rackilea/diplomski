public class MyJPanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;

    private Timer timer;
    private Image backgroundImage;
    private Image player;
    private int playerX, playerY;
    private int projectileX,projectileY;
    private Image projectileImage;
    private ArrayList<ProjectileThread> projectiles = new ArrayList<ProjectileThread>();

    static boolean gameLoop = true;

    public MyJPanel(Image backgroundImage, Image player,Image projectileImage)
    {
        this.backgroundImage = backgroundImage;
        this.player = player;
        this.projectileImage = projectileImage;
        this.setLayout(null);

        timer = new Timer(50, this);
        timer.start();

        this.addKeyListener(new KeyAdapter() // Listens for a keyboard event
        {
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) // If pressing space - shoot
                {
                    ProjectileThread projectileThread = new ProjectileThread(playerX,playerY);
                    projectileThread.start(); // Create a Thread and call run() method
                    projectiles.add(projectileThread);
                    repaint();
                }
            }
        });

        // Mouse listener
        this.addMouseMotionListener(new MouseMotionListener()
        {   
            @Override
            public void mouseMoved(MouseEvent e)
            {
                playerX = e.getX();
                playerY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e)
            {

            }
        });
        hideMouseCursor();

        this.setFocusable(true);
        this.setVisible(true);
    } // End of JPanel constructor

    public int getX()
    {
        return this.projectileX;
    }

    public int getY()
    {
        return this.projectileX;
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        graphics.drawImage(backgroundImage,0,0,this.getWidth(),this.getHeight(),null); // Draw the background
        graphics.drawImage(player,playerX,playerY,null); // Draw the player
        for (ProjectileThread projectileThread : projectiles)
        {
            graphics.drawImage(projectileImage,projectileThread.getX(),projectileThread.getY(),null);
        }
    }

    public void  hideMouseCursor() // Hides the mouse cursor
    {
        //Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorbackgroundImgage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorbackgroundImgage, new Point(0, 0), "Blank Cursor");

        // Set the blank cursor to the JPanel.
        this.setCursor(blankCursor);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) // Without the method and the repaint() the mouse listener will not work 
    {
        repaint();
    }

    public class ProjectileThread extends Thread
    {   
        private int projectileX;
        private int projectileY;

        public ProjectileThread(int playerX,int playerY)
        {
            this.projectileX = playerX + player.getWidth(null);
            this.projectileY = playerY + player.getHeight(null) / 2 - 28;
        }
        @Override
        public void run()
        {
            try 
            {
                while (projectileX < backgroundImage.getWidth(null) - projectileImage.getWidth(null))
                {
                    projectileX += 2;
                    Thread.sleep(10);
                    repaint(); // Goes to paintComponent() method
                }
                projectiles.remove(this); // Remove the thread from the list
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public int getX()
        {
            return this.projectileX;
        }

        public int getY()
        {
            return this.projectileY;
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("A Game by me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Making the frame take a full screen

        ImageIcon backgroundImageIcon = new ImageIcon("space_background_2.jpg");
        Image backgroundImgage = backgroundImageIcon.getImage();
        ImageIcon playerImageIcon = new ImageIcon("spaceship_1.png");
        Image playerImage = playerImageIcon.getImage();
        ImageIcon projectileIcon = new ImageIcon("spaceship_projectile_1.png");
        Image projectileImage = projectileIcon.getImage();  

        frame.add(new MyJPanel(backgroundImgage,playerImage,projectileImage));
        frame.setVisible(true);

        while (gameLoop)
        {

        }
    }
} // End of MyJPanel