class Example {
    String a;
    String b;
    // methods below for testing
    public Example(String a) {
        this.a = a;
    }
    public String getA() {
        return a;
    }
    @Override
    public String toString() {
        return String.format("Example with a = %s", a);
    }
}
// initializing test list of Examples
List<Example> list = Arrays.asList(new Example("a"), new Example("b"));

// printing original list
System.out.println(list);

// initializing projected list by mapping
// this is where the real work is

List<String> newList = list
    // streaming list
    .stream()
    // mapping to String through method reference
    .map(Example::getA)
    // collecting to list
    .collect(Collectors.toList());

// printing projected list
System.out.println(newList);