@Entity
public class A {
@ManyToMany
    @JoinTable(name = "A_B", joinColumns = { @JoinColumn(name = "A_fk") }, inverseJoinColumns = { @JoinColumn(name = "B_fk") })
    private Set<B> bSet = new LinkedHashSet<B>();
}