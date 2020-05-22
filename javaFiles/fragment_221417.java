public static void main(String[] args) {
    List<Foo> fooList = asList(new Foo("1", "1"), new Foo("2", "2"), new Foo("3", "3"));
    List<Bar> barList = asList(new Bar("4", 4), new Bar("3", 3), new Bar("5", 5));

    Set<Blah> fooSet = fooList.stream().map(Main::fooToBlah).collect(toCollection(HashSet::new));
    Set<Blah> barSet = barList.stream().map(Main::barToBlah).collect(toCollection(HashSet::new));

    barList.stream()
            .filter(bar -> !fooSet.contains(barToBlah(bar)))
            .forEach(System.out::println);
    fooList.stream()
            .filter(foo -> !barSet.contains(fooToBlah(foo)))
            .forEach(System.out::println);
}

static Blah fooToBlah(Foo foo) {
    return new Blah(foo.name, foo.age);
}

static Blah barToBlah(Bar bar) {
    return new Blah(bar.barName, "" + bar.codeBar);
}

static class Blah {
    String name;
    String age;

    public Blah(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        ...
    }

    @Override
    public int hashCode() {
        ...
    }
}