@Entity
public class Parent {
    @OneToMany(mappedBy="parent")
    @OrderColumn(name="order")
    private List<Child> children;
    ...
}

@Entity
public class Child {
    ...
    //the index column is mapped as a property in the associated entity
    @Column(name="order")
    private int order;

    @ManyToOne
    @JoinColumn(name="parent_id", nullable=false)
    private Parent parent;
    ...
}