@Entity
public class Parent {

    @Embeddedid
    private ParentId id;

    /*******************************************************/
    /*******************************************************/
    /*******************************************************/
    // @formatter:off
    @OneToMany(
        cascade = { CascadeType.MERGE, CascadeType.PERSIST },
        fetch = FetchType.EAGER
    )
    @JoinColumns(
        {
            @JoinColumn(name = "parent_key1"),
            @JoinColumn(name = "parent_key2")
        }
    )
    // @formatter:on
    /*******************************************************/
    /*******************************************************/
    /*******************************************************/
    private List<Child> children;

    public Parent() {
    }

    public Parent(final ParentId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Parent [id=" + this.id + ", children=" + this.children + "]";
    }

    // (Getters and setters)
}