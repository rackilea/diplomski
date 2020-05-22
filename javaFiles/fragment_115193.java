@Entity
public class A extends DeletableEntity{

    @OneToMany(mappedBy = "a")
    @Where(clause = "DELETED=0 or DELETED is null")
    private Set<B> bSet = new HashSet<B>();

    public Set<B> getBSet() {
        return bSet;
    }

    public void setBSet(Set<B> bSet) {
        this.bSet = bSet;
    }
}