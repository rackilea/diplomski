public interface Clickable {
    public abstract void activate();
}

public abstract class MenuBox implements Clickable{
    private String label;
    private int x,y,width,height;
    public MenuBox(String label,int x,int y,int width,int heigth){
        this.label = label;
        this.x = x;
        this.y =y;
        this.width=width;
        this.height=heigth;
    }
}