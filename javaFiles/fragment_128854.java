@Entity
    public class Parent{

    @Id
    private String name;

    @OneToMany(fetch= FetchType.LAZY)
    private Set<Child> childs;

    public Parent(String name) {
        this.name = name;
    }
    public Parent(){}
}

@Entity
public class Child{

    @Id
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    private Parent parent;
}