class C {
    public final Long id;
    public final String value;

    C(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}


public void objectify() {
    List<C> items = Arrays.asList(new C(0L, "a"), new C(1L, "b"));
    List<Object[]> coarse = new ArrayList<>();
    List<Object[]> detailed = new ArrayList<>();
    for (C c: items)
    {
        coarse.add(new Object[]{c});
        detailed.add(new Object[]{c.id, c.value});
    }
}