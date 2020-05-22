public class Foo{
    private UUID fooId;

    @OneToMany(mappedBy = "bar")
    private List<Bar> bars;
}

public class Bar{
    private UUID barId;

    @ManyToOne
    @JoinColumn(name = "fooId")
    private Foo foo;
}