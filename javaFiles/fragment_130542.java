public interface MovementStrategy {
    public Move selectMove (Actor actor, ActorSituation theirSituation);
}

public class MonsterTypes {
    public static MonsterType GOBLIN = new MonsterType( "goblin", new AttackMover(1.2));
    public static MonsterType TROLL = new MonsterType( "troll", new AttackMover(0.45));
    public static MonsterType DEER = new MonsterType( "deer", new FleeMover(2.0));

    // useful to have, also.
    public static List<MonsterType> getAllRegisteredTypes(); 



    public static class MonsterType {
        protected String name;
        protected MovementStrategy moveStrategy;
        // TODO -- getters & setters for all properties.

        // constructor.
        public MonsterType (String name, MovementStrategy moveStrategy) {
            this.name = name;
            this.moveStrategy = moveStrategy;
        }
    }
}

public class AttackMover implements MovementStrategy {
    // SPEC: generally move towards/attack PC, with varying speeds.
}
public class FleeMover implements MovementStrategy {
    // SPEC: generally run away from PCs.
}