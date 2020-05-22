class A {
    private final String name;
    public A(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println("Name: " + this.name);
    }
}
//...
A p = new A("p");
A q = new A("q");