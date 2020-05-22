class Boo {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}

class Foo {
    private final Boo boo;

    public Foo() {
        boo = new Boo();
        boo.setName("boo");
    }
}