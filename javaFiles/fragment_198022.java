public class GameScreen extends JPanel {
    public paintComponent(Graphics g) {
        for (shot : yourListOfShots) {
             shot.draw(g);
        }
        // And draw your ship and whatever else you need
    }
 }