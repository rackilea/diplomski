public interface CreatureFactory {
    public Stats newStats();
    public Attack newAttack();
}

public class Creature {
    public Creature(CreatureFactory f) {
      this.stats = f.newStats();
      this.attack = f.newAttack();
    }
}

public class Monster extends Creature {
    public Monster() {
        super(new MonsterFactory());
    }
}