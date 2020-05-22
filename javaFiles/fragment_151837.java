public class Player{

    private int x;
    private int y;
    private int pSize = 30;

    public Player(int x, int y, PApplet sketch){
        this.x = x;
        this.y = y;
        this.sketch = sketch; 
    }

    public void show(){
        sketch.noStroke();
        sketch.rect(x, y, pSize, pSize);
    }   
}