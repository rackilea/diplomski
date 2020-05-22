public class Entities {

    // Entities of class A
    private enum EntitiesOfA {
        ENTITY_A_1(1, "EntityA 1", "foo"), // A1
        ENTITY_A_2(2, "EntityA 2", "bar"), // A2
        ENTITY_A_3(3, "EntityA 3", "baz"); // A3

        private MyEntityA entity;


        private EntitiesOfA(int id, String name, String foo) {
            this.entity = new MyEntityA(id, name, foo);
        }

        public MyEntityA getEntity() {
            return this.entity;
        }
    }

    // Entities of class B
    private enum EntitiesOfB {
        ENTITY_B_1(4, "EntityB 1", 10), // B1
        ENTITY_B_2(5, "EntityB 2", 11), // B2
        ENTITY_B_3(6, "EntityB 3", 12); // B3

        private MyEntityB entity;


        private EntitiesOfB(int id, String name, int value) {
            this.entity = new MyEntityB(id, name, value);
        }

        public MyEntityB getEntity() {
            return this.entity;
        }
    }


    // All Entities
    public static final Set<AbstractEntity> ALL;

    static {
        // I use HashSet instead of TreeSet because I have
        // not implemented the comparable interface
        Set<AbstractEntity> allEntities = new HashSet<>();
        for (EntitiesOfA entity : EntitiesOfA.values()) {
            allEntities.add(entity.getEntity());
        }
        for (EntitiesOfB entity : EntitiesOfB.values()) {
            allEntities.add(entity.getEntity());
        }

        ALL = Collections.unmodifiableSet(allEntities);
    }


    public static void main(String[] args) {
        for (AbstractEntity entity : ALL) {
            System.out.println("Entity ID = " + entity.getId() + " NAME = " + entity.getName());
            entity.someAbstractMethods();

            if (entity instanceof MyEntityA) {
                MyEntityA a = (MyEntityA) entity;
                System.out.println("Entity A with foo = " + a.getFoo());
                a.someMethods();
            } else if (entity instanceof MyEntityB) {
                MyEntityB b = (MyEntityB) entity;
                System.out.println("Entity B with value = " + b.getValue());
                b.someMethods();
            } else {
                System.err.println("ERROR: Unrecognised subclass");
            }
        }
    }
}