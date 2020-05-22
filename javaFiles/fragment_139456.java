Random r = new Random()  
public Ball()
{
    randomPosition();
    setRandomDirection();
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

    ImageIcon ii = new ImageIcon(this.getClass().getResource("chicken.gif"));
    ball = ii.getImage();
    this.x = r.nextInt();
    this.y = r.nextInt();

}