public class GameWindow extends JPanel {

    public static ArrayList<GameTile> gameTiles = new ArrayList<GameTile>();

    public static void main(String[] args) {
        new GameWindow();
    }

    public GameWindow() {

        JFrame frame = new JFrame();    
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);

        // add all the tiles (I just use x and y as parameters here)
        gameTiles.add(new GameTile(10, 10));
        gameTiles.add(new GameTile(50, 10));

    }

    public void paintComponent(Graphics g) {

        for(int i = 0; i < gameTiles.size(); i++) {
            gameTiles.get(i).draw(g);
        }

    }

}