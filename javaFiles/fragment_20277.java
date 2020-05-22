class WorldManager extends JPanel
{

    private World world1;
    private Person hero;

    public void paintComponent(Graphics g) {
         super.paintComponent(); // paints the background, if opaque
         world.paint(g);
         hero.paint(g);
    }
}