@MappedSuperclass
abstract class AbstractSomething {
    @Id
    int myMember;
}

@Entity
@IdClass(ConcreteClass.Key.class)
class ConcreteClass extends AbstractSomething {
    public static class Key {
        int myMember;
        int someOtherMember;
        // constructor, equals, hashCode
    }

    @Id
    int someOtherMember;
}