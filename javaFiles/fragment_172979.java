public class Foo{
    private UUID fooId;

    @OneToMany(mappedBy = "bar", cascade=CascadeType.ALL)
    private List<FooBar> bars;
}

public class Bar{
    private UUID barId;

    @OneToMany(mappedBy = "foo", cascade=CascadeType.ALL)
    private List<FooBar> foos;
}

@Entity
@Table(name="FOO_BAR")
public class FooBar{
    private UUID fooBarId;

    @ManyToOne
    @JoinColumn(name = "fooId")
    private Foo foo;

    @ManyToOne
    @JoinColumn(name = "barId")
    private Bar bar;

    //You can store other objects/fields on this table here.
}