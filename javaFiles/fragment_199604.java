public class TestGame extends StateBasedGame {

    Image a;
    Image b;

    public void init(GameContainer container, StateBasedGame game) 
            throws SlickException {
        a = new Image("blabla1.png");
        b = new Image("blabla2.png");
    }

    public void update(GameContainer container,
                       StateBasedGame game,
                       int delta) throws SlickException {
        // Put your update stuff here
    }

    public void render(GameContainer container,
                       StateBasedGame game,
                       Graphics g) throws SlickException {
        if (a == 0) {
            g.drawImage(a, 0, 0);
        } else if (a == 1) {
            g.drawImage(b, 0, 100);
        }
    }
}