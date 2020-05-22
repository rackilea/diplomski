class DrawArea extends JPanel
{
    public DrawArea (int width, int height)
    {
        this.setPreferredSize (new Dimension (width, height)); // size
    }

    public void paintComponent (Graphics g)
    {
        maze.show (g);
        // display current state of colony
    }
}