@Entity
public static class Parent {
    @Id
    private int parentID;
    private int childFK;
    @OneToMany(orphanRemoval=true)
    // @JoinColumn(name="childFK") ignored by ObjectDB
    Set<Child> children;

    public Parent(int p,int c) {
        this.parentID = p;
        this.childFK = c;
    }

    public Set<Child> getChildren(){
        return children;
    }
}