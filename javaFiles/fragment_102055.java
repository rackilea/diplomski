public class Foo{
    private UUID fooId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "barId")
    private Bar bar;
}

public class Bar{
    private UUID barId;

    @OneToOne(mappedBy = "bar")
    private Foo foo;
}