public class Foo{
    private UUID fooId;

    @OneToOne
    private Bar bar;
}

public class Bar{
    private UUID barId;
    //No corresponding mapping to Foo.class
}