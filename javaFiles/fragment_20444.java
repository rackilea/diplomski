@Entity
public class Parent {
    @Id private Long id;

    @OneToMany(mappedBy="parent")
    private List<Child> children = new ArrayList<Child>();

    ...

    protected void setChildren(List<Child> children) {
        this.children = children;
    }

    public void addToChildren(Child child) {
        child.setParent(this);
        this.children.add(child);
    }
}