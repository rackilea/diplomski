public abstract class Enemy{
    protected Hitbox hbox;
    public Enemy(int a, int b) {
        hbox = new Hitbox(a, b);
    }
}

public class AngryLady extends Enemy {
    public AngryLady(int a, int b) {
        super(a, b);
    }
}