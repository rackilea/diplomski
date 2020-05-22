class TestClass implements HelloWorld {
    String name = "world";

    @Override
    public void greet() {
        greetSomeone("world");
    }

    @Override
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Hello " + name);
    }
}