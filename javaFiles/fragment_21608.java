public class VirusGamePanel extends JPanel{
    private static final long serialVersionUID = 1L;//serialVersionUID field
    Random colour = new Random();//the outside ovals will always be a random colour
    private int sizeX = 0;//the x size of the outside ovals 
    private int sizeY = 0;//the y size of the outside ovals
    int score = 0;
    static String scorestring = "Score: ";
    Color rand = new Color(colour.nextInt(255), colour.nextInt(255), colour.nextInt(255)); //generate the random colour

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.magenta);
        g.drawString(scorestring+score,275,250);
        g.setColor(Color.orange);
        g.drawOval(200, 150, 200, 200);
        g.setColor(rand);
        g.fillOval(270 - sizeX / 2, 50 - sizeY / 2, sizeX, sizeY);//these six ovals are supposed to increase in size
        g.fillOval(100 - sizeX / 2,100 - sizeY / 2, sizeX, sizeY);
        g.fillOval(450 - sizeX / 2,100 - sizeY / 2, sizeX, sizeY);
        g.fillOval(100 - sizeX / 2,400 - sizeY / 2, sizeX, sizeY);
        g.fillOval(450 - sizeX / 2,400 - sizeY / 2, sizeX, sizeY);
        g.fillOval(275 - sizeX / 2,450 - sizeY / 2, sizeX, sizeY);
        inc();
    }

    public static void main(String[] args) {
      JPanel panel = new VirusGamePanel();

      JFrame frame = new JFrame("Virus");
      frame.setSize(700, 700);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.setVisible(true);
    }

    private void inc()//increase the size of the ovals
    {
            sizeX++;
            sizeY++;
            repaint();
    }
}