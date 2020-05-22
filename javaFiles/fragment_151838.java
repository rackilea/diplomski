public class Game extends PApplet {

    private Player p;

    private int cW = 1000;
    private int cH = 600;

    public void settings(){
        size(cW,cH);
        p = new Player(cW/2, cH/2, this);
    }

    //rest of your code