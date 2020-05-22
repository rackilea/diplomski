import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class StarPanel extends JPanel
{
  private int xStarting;
  private int yStarting;

  private int numberOfRows;
  private int numberOfColumns;

  private int xDisplacement;
  private int yDisplacement;

  public StarPanel(int xStarting, int yStarting,
                   int numberOfRows, int numberOfColumns,
                   int xDisplacement, int yDisplacement)
  {
    this.xStarting = xStarting;
    this.yStarting = yStarting;
    this.numberOfRows = numberOfRows;
    this.numberOfColumns = numberOfColumns;
    this.xDisplacement = xDisplacement;
    this.yDisplacement = yDisplacement;
  }

  public static void main(String[] args)
  {
    StarPanel starPanel = new StarPanel(50, 50, 5, 6, 75, 75);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(starPanel);
    frame.setBounds(300, 200, 500, 600);
    frame.setVisible(true);
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    for (int row = 0; row < numberOfRows; row++) {
      for (int column = 0; column < numberOfColumns; column++) {
        drawStar(g, xStarting + (row * xDisplacement), yStarting + (column * yDisplacement), 50);
      }
    }
  }

  // drawLine the star
  public static void drawStar(java.awt.Graphics g, int x, int y, int size)
  {
    g.drawLine(x+size/2, y+size/6, x+4*size/5, y+5*size/6);
    g.drawLine(x+4*size/5,y+5*size/6, x+size/6, y+2*size/5);
    g.drawLine(x+size/6, y+2*size/5, x+5*size/6, y+2*size/5);
    g.drawLine(x+5*size/6, y+2*size/5, x+size/5, y+5*size/6);
    g.drawLine(x+size/5, y+5*size/6, x+size/2, y+size/6);
  }
}