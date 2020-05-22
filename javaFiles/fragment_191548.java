@Entity
@Table(name="Book")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="published")
@DiscriminatorValue(value="true")
public class A {
    private String ID;
    private String Name;
    // ...
}

@Entity
@Table(name="Book")
@DiscriminatorValue(value="true")
public class B extends A {
    public String node_ID;
    // ...
}