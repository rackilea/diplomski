@Entity
public class Parent {
    @OneToMany
    @OrderColumn(name="order")
    @JoinColumn(name="parent_id", nullable=false)
    private List<Child> children;
    ...
}

@Entity    
public class Child {    
    ...
    @ManyToOne
    @JoinColumn(name="parent_id", insertable=false, updatable=false, nullable=false)
    private Parent parent;
    ...
}