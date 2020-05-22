import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Elevator extends JFrame implements ActionListener
{
    private final int   DISPLAY_WIDTH   = 800;
    private final int   DISPLAY_HEIGHT  = 600;

    private JPanel          guiPanel, buttonPanel;
    private DisplayPanel    display;
    private JLabel          Title;
    private JButton         Floor;
    private JComboBox       Select;

    int         locX, locY;
    final int   LIMIT           = 10;
    final int   NUM_ROWS        = 10;
    final int   WINDOWWIDTH     = 12;
    final int   WINDOWHEIGHT    = 25;
    final int   WINDOWSPACING   = 10;
    final int   FLOORSPACING    = 30;
    final int   FLOOROFFSET     = -10;
    final int   ELEVATOR_COLUMN = 5;

    private static final int    NUM_ITERATIONS  = 10;   // number of floors for combo box selection
    private int                 lvlChoice;              // variable holding elevator level choice for item event

    private int buildX, buildY, buildW, buildH; // building height dem

    Color   drkGrn  = new Color(49, 216, 91);   // building ground color
    Color   flWind  = new Color(163, 156, 77);  // default floor window color
    Color   bldCol  = new Color(176, 201, 212); // building color
    Color   crntFl  = new Color(255, 247, 0);   // current floor color for elevator

    // an array with all your clouds
    private Cloud[] clouds;
    private Tree[]  trees;

    public static void main(String[] args)
    {
        Elevator frame = new Elevator();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // added the cloud initialization in there
        frame.initializeVariables();

        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);

        // starts ticking each 30 ms
        frame.tick();
    }

    private void tick()
    {
        // while loop for ever and ever
        while (true)
        {
            // ticks all the clouds
            for (int i = 0; i < clouds.length; i++)
            {
                clouds[i].tick();
            }
            // updates the JFrame graphics
            display.repaint();
            // pauses the ticking for 30 ms
            try
            {
                Thread.sleep(30);
            } catch (InterruptedException e)
            {
            }
        }
    }

    public void initializeVariables()
    {
        locX = 300;
        locY = 150;
        buildX = locX - 20;
        buildY = locY - 10;
        buildH = 375;
        buildW = 250;
        lvlChoice = 1;
        // puts 3 clouds in our array
        clouds = new Cloud[] { new Cloud(800, 100, 45, 3, true), new Cloud(700, 50, 30, 2, false),
                new Cloud(777, 240, 40, 2, false), };
        trees = new Tree[] { new Tree(140, 400), new Tree(500, 400), new Tree(650, 470), new Tree(600, 420),
                new Tree(190, 390), new Tree(45, 425), new Tree(75, 450) };
    }

    public void setUpGUI()
    {
        Container window = getContentPane(); // you attach Jcomponents to this pannel
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());
        buttonPanel = new JPanel(new FlowLayout());
        // TODO add title panel
        /* Title = new JLabel("Elevator");
         Title.setFont(new Font(" San Serif", Font.PLAIN, 20));
         titlePanel.add(Title);*/

        Floor = new JButton("Floor");
        Floor.addActionListener(this);

        Select = new JComboBox<>();

        for (int i = 0; i < NUM_ITERATIONS; i++)
        {
            Select.addItem(String.valueOf(i + 1)); // this takes the int value and the parses it to a string
        }

        buttonPanel.add(Select);
        buttonPanel.add(Floor);

        window.add(buttonPanel, BorderLayout.NORTH);
        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        lvlChoice = Integer.parseInt((String) Select.getSelectedItem());
        display.repaint();

        // moves each cloud by the respective velocity
        for (int i = 0; i < clouds.length; i++)
            clouds[i].x -= clouds[i].velX;
    }

    class DisplayPanel extends JPanel
    {
        private static final long serialVersionUID = 1L;

        DisplayPanel()
        {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }

        // executes all paint methods
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            backDrop(g2d);

            for (Cloud c : clouds)
            {
                if (!c.Foreground) c.draw(g2d);
            }
            buildingLoop(g2d);
            for (Cloud c : clouds)
            {
                if (c.Foreground) c.draw(g2d);
            }
            for (Tree t : trees)
            {
                t.draw(g2d);
            }
        }

        // static background objects (ground, trees, ect..)
        public void backDrop(Graphics2D g2d)
        {

            g2d.setColor(drkGrn);
            g2d.fillRect(0, 500, getWidth(), getHeight());

        }

        // building the building and windows for the building
        public void buildingLoop(Graphics2D g2d)
        {

            g2d.setColor(bldCol);
            g2d.fillRect(buildX, buildY, buildW, buildH);
            g2d.setColor(flWind);
            for (int j = 1; j <= NUM_ROWS; j++)
            { // draws row
                for (int i = 0; i <= LIMIT; i++)
                { // draws window's
                    if (i == ELEVATOR_COLUMN && j == NUM_ROWS - lvlChoice + 1)
                    {
                        g2d.setColor(crntFl);
                    }
                    g2d.fillRect(i * (WINDOWWIDTH + WINDOWSPACING) + buildX + WINDOWSPACING,
                            buildY + j * FLOORSPACING - FLOOROFFSET, WINDOWWIDTH, WINDOWHEIGHT);
                    g2d.setColor(flWind);
                }
            }
        }
    }

}

class Cloud
{
    int x = 800, y, velX = 3; // position of x on cloud and velociity of cloudes

    final Color blu1    = new Color(157, 215, 255); // cloud colors
    final Color blu2    = new Color(93, 172, 227);
    final Color blu3    = new Color(62, 167, 240);
    final Color blu4    = new Color(136, 156, 169);
    final Color blu5    = new Color(209, 230, 245);

    int     Size;
    boolean Foreground;

    public Cloud(int x, int y, int Size, int velX, boolean Foreground)
    {

        this.x = x;
        this.y = y;
        this.Size = Size;
        this.velX = velX;
        this.Foreground = Foreground;

    }

    public void tick()
    {
        x -= velX;
        if (x < -100) x = 1000;
    }

    public void draw(Graphics2D g2d)
    {
        // cloud 1
        // y starts at 100 to be put in method argument
        g2d.setColor(blu4);
        g2d.fillOval(x, y, Size, Size);
        g2d.setColor(blu1);
        g2d.fillOval(x + 15, y - 10, Size, Size);
        g2d.setColor(blu3);
        g2d.fillOval(x + 30, y + 10, Size, Size);
        g2d.setColor(blu2);
        g2d.fillOval(x + 45, y - 10, Size, Size);
        g2d.setColor(blu5);
        g2d.fillOval(x + 57, y, Size, Size);
    }
}

class Tree
{
    int xPoint, yPoint;

    public Tree(int xPoint, int yPoint)
    {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    public void draw(Graphics2D g2d)
    {
        int leafSize = 25;

        // graphics variables
        final int tWidth = 10;
        final int tHeiht = 120;
        final Color plmLeaf = new Color(6, 145, 84);
        final Color trunk = new Color(170, 85, 0);

        g2d.setColor(trunk);
        g2d.fillRect(xPoint + 25, yPoint, tWidth, tHeiht);

        g2d.setColor(plmLeaf);
        g2d.fillOval(xPoint, yPoint, leafSize, leafSize);
        g2d.fillOval(xPoint + 5, yPoint - 10, leafSize, leafSize);
        g2d.fillOval(xPoint + 5, yPoint + 10, leafSize, leafSize);
        g2d.fillOval(xPoint + 10, yPoint, leafSize, leafSize);
        g2d.fillOval(xPoint + 10, yPoint + 10, leafSize, leafSize);
        g2d.fillOval(xPoint + 30, yPoint - 10, leafSize, leafSize);
        g2d.fillOval(xPoint + 30, yPoint + 10, leafSize, leafSize);
        g2d.fillOval(xPoint + 35, yPoint, leafSize, leafSize);
        g2d.fillOval(xPoint + 35, yPoint + 10, leafSize, leafSize);

    }
}