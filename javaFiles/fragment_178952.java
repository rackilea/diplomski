List<Abstraction> list = new ArrayList<>(2);

@Inject
public Composite(@Qualifier("one") Abstraction one, @Qualifier("two") Abstraction two) {
    list.add(one);
    list.add(two);
}