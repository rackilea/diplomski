public void execute(Object o) {
    //this makes the code compiles
    //and assures that you won't have a ClassCastException
    if (o instanceof ClassA) {
        ((A)o).exampleMethod("test");
    }
    if (o instanceof ClassB) {
        ((B)o).exampleMethod("test");
    }
}