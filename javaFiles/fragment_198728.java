public class AllEntities {

private enum Entities {
    ENTITY_A_1(new MyEntityA(1, "EntityA 1", "foo")), // A1
    ENTITY_A_2(new MyEntityA(2, "EntityA 2", "bar")), // A2
    ENTITY_A_3(new MyEntityA(3, "EntityA 3", "baz")), // A3
    ENTITY_B_1(new MyEntityB(4, "EntityB 1", 10)), // B1
    ENTITY_B_2(new MyEntityB(5, "EntityB 2", 11)), // B2
    ENTITY_B_3(new MyEntityB(6, "EntityB 3", 12)); // B3

    private AbstractEntity entity;


    private Entities(AbstractEntity entity) {
        this.entity = entity;
    }

    public AbstractEntity getEntity() {
        return this.entity;
    }
}


// All Entities
public static final Set<AbstractEntity> ALL;

static {
    // I use HashSet instead of TreeSet because I have
    // not implemented the comparable interface
    Set<AbstractEntity> allEntities = new HashSet<>();
    for (Entities entity : Entities.values()) {
        allEntities.add(entity.getEntity());
    }
    ALL = Collections.unmodifiableSet(allEntities);
}