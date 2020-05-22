public class GameScreen extends JComponent {
  ....

  public void paintComponent(Graphics g) {
    drawBackground(g);
    drawItems(g);
    drawOtherStuff(g); // e.g. animated explosions etc. on top of everything else
  }  
}