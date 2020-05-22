@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
@IdClass(Base.class)
public abstract class Base implements Serializable {
    @Id @ManyToOne protected Test test;
    @Id @ManyToOne protected Test2 test2;
    @Id private int type;
}

@Entity
@DiscriminatorValue("1")
public class Child1 extends Base {
    public Child1(){
        type=1;
    }
}

@Entity
@DiscriminatorValue("2")
public class Child2 extends Base {
    public Child2(){
        type=2;
    }
}