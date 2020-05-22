public static B create(String name) {
    int age = 18;
    return new B(name, age);
}

private B(String name, int age){
    super(name, age);
}