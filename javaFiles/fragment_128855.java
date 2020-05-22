@Entity
public class Child implements Serializable {

    @Id
    private String name;

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    private Parent parent;
}

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