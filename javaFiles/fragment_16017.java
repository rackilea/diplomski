public class MainApplet extends LwjglApplet {
    private static final long serialVersionUID = 1L;
    TitansArena game;
    public MainApplet() {
        this(new TitansArena());
    }

    private MainApplet(TitansArena ta) {
        super(ta, false);
        game = ta;
        game.ap = this; 
    }
}