public class A {
    mapped id
    mapped name
    @ManyToOne B b;
}

public class B {
    mapped @OneToMany(mappedBy="b") List<A>
    mapped name
}