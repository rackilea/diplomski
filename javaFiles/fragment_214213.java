public static void main(String[] args) throws IOException {
    Foo foo = new Foo();
    foo.setId(1);

    Foo fooChild = new Foo();
    fooChild.setId(2);
    fooChild.setFooList(new ArrayList<>());

    Foo fooChild2 = new Foo();
    fooChild2.setId(3);
    fooChild2.setFooList(new ArrayList<>());

    foo.setFooList(Arrays.asList(fooChild, fooChild2));

    Bar bar = new Bar();
    bar.setFooList(FooJsonSimplifiedSerializationWrapper.convertFromFoo(Arrays.asList(foo)));

    System.out.println(new ObjectMapper().writeValueAsString(foo));
    System.out.println(new ObjectMapper().writeValueAsString(bar));
}