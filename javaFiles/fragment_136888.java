if (bar instanceof Foo) {
    System.out.println(true);
}

// Or
if (Foo.class.isInstance(bar)) {
    System.out.println(true);
}

// Or
if (Foo.class.isAssignableFrom(Bar.class)) {
    System.out.println(true);
}