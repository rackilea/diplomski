@Entity
@Table(name="TABLE_A")
public class A {

    @OneToMany
    @JoinTable(
            name="TABLE_B",
            joinColumns = @JoinColumn( name="A_ID"),
            inverseJoinColumns = @JoinColumn( name="B_ID")
    )
    public Set<C> cs;
}

@Entity
@Table(name="TABLE_C")
public class C {

}