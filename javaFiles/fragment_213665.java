@Entity
public class Child {

    private Integer id;

    @ManyToOne
    /*******************************************************************************/
    /*******************************************************************************/
    /*******************************************************************************/
    // @formatter:off
    @JoinColumns(
        {
            @JoinColumn(name = "parent_key1", insertable = false, updatable = false),
            @JoinColumn(name = "parent_key2", insertable = false, updatable = false)
        }
    )
    // @formatter:on
    /*******************************************************************************/
    /*******************************************************************************/
    /*******************************************************************************/
    private Parent parent;

    public Child() {
    }

    public Child(final Integer id, final Parent parent) {
        this.id = id;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Child [id=" + this.id + ", parent.getId()=" + this.parent.getId() + "]";
    }

    // (Getters and setters)
}