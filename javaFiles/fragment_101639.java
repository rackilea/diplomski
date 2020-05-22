public abstract class Enemy{
    protected Hitbox hbox;
    public Enemy(Hitbox hitbox) {
        hbox = hitbox;
    }
}

public class AngryLady extends Enemy {
    public AngryLady(Hitbox hitbox)) {
        super(hitbox);
    }
}

//...
AngryLady angryLady = new AngryLady(HitboxFactory.createHitbox(HitboxType.ANGRY));
//...