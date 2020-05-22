@Entity
public class Parent {
    @Id
    private long id;

    @OneToMany(mappedBy = "parent")
    private Collection<Child> children; 
}


@Entity
@DiscriminatorColumn(name = "decider", discriminatorType = DiscriminatorType.STRING)
public abstract class Child {
    @Id
    private long id;

    @ManyToOne
    private Parent parent;
    // other common fields
}

@Entity
@DiscriminatorValue("X")
public class ChildX extends Child {
    // specific fields for child x
} 

// more children types