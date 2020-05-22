public abstract class AbstractEntity {
    private int hitPoints;

    protected AbstractEntity(int initialHitPoints) {
        this.hitPoints = initialHitPoints;
    }

    public int getHitPoints(){
        return hitPoints
    }

    void gainHitPoints(int amount) {
        hitPoints += amount;
    }
}

public class Monster extends AbstractEntity {
    public Monster() {
        // Every monster starts off with 4 hit points
        super(4);
    }
}