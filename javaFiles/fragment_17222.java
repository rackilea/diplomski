import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.awt.image.BufferedImage;

public class TurtlePanel extends JPanel
{
    private GraphicPanel graphics = new GraphicPanel();
    private JTextField console = new JTextField(15);

    public TurtlePanel() {
        add(graphics);
        add(console);

        console.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                if (console.getText().contains("penup"))
                {
                    graphics.penUp();
                }
                else if (console.getText().contains("pendown"))
                {
                    graphics.penDown();
                }
                else if (console.getText().contains("turnleft"))
                {
                    graphics.turnLeft();
                }
                else if (console.getText().contains("turnright"))
                {
                    graphics.turnRight();
                }
                else if (console.getText().contains("forward"))
                {
                    graphics.forward(50);
                }
                else if (console.getText().contains("backward"))
                {
                    graphics.backward(50);
                }
                else if (console.getText().contains("black"))
                {
                    graphics.black();
                }
                else if (console.getText().contains("green"))
                {
                    graphics.green();
                }
                else if (console.getText().contains("red"))
                {
                    graphics.red();
                }
                else if (console.getText().contains("reset"))
                {
                    graphics.clear();
                }
                else
                {
                    JOptionPane.showMessageDialog(console, "Invalid command, try again");
                }

                console.setText("");
                graphics.repaint();
            }
        });
    }

    public static void main(String[] args) {
        TurtlePanel mainPanel = new TurtlePanel();

        JFrame frame = new JFrame("Simple Testing Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

class GraphicPanel extends JPanel 
{
    private int xPos = 400, yPos = 300;
    private boolean penUp = false;
    private Color color = Color.black;

    private BufferedImage image;
    private final static Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private Direction direction = Direction.DOWN;

    GraphicPanel() {

        setPreferredSize(new Dimension(800, 600));

        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

        setMaximumSize(new Dimension(image.getWidth(), image.getHeight()));

        clear();
    }

    // place pen onto canvas
    public void penDown()
    {
        penUp = false;
    }

    // raise pen from canvas
    public void penUp()
    {
        penUp = true;
    }

    // turn right from current position
    public void turnRight()
    {
        switch (direction)
        {
            case UP:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
        }
    }

    // turn left from current position
    public void turnLeft()
    {
        switch (direction)
        {
            case UP:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
    }

    // draw forward a certain amount
    public void forward(int amount)
    {
        if (penUp)
        {
            return;
        }

        switch (direction)
        {
            case UP:
                drawLine(xPos, yPos, xPos, yPos - amount );
                yPos = yPos - amount;
                break;
            case DOWN:
                drawLine(xPos, yPos, xPos, yPos + amount );
                yPos = yPos + amount;
                break;
            case LEFT:
                drawLine(xPos, yPos, xPos - amount, yPos );
                xPos = xPos - amount;
                break;
            case RIGHT:
                drawLine(xPos, yPos, xPos + amount, yPos );
                xPos = xPos + amount;
                break;
        }
    }

    // draw backwards a certain amount
    public void backward(int amount)
    {
        if (penUp)
        {
            return;
        }

        switch (direction)
        {
            case UP:
                drawLine(xPos, yPos, xPos, yPos + amount );
                yPos = yPos + amount;
            case DOWN:
                drawLine(xPos, yPos, xPos, yPos - amount );
                yPos = yPos - amount;
                break;
            case LEFT:
                drawLine(xPos, yPos, xPos + amount, yPos );
                xPos = xPos + amount;
            case RIGHT:
                drawLine(xPos, yPos, xPos - amount, yPos );
                xPos = xPos - amount;
                break;
        }
    }

    // change colour to black
    public void black()
    {
        color = Color.black;
    }

    // change colour to green
    public void green()
    {
        color = Color.green;
    }

    // change colour to red
    public void red()
    {
        color = Color.red;
    }

    // draw lines to xy co-ordinates
    public void drawLine(int x1, int y1, int x2, int y2) {

        Graphics g = image.getGraphics();

        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    // Clears the image contents.
    public void clear() {

        Graphics g = image.getGraphics();

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // render the image on the panel.
        g.drawImage(image, 0, 0, null);
    }
}