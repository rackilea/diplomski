class AbstractClass<T> {
    protected List<T> subList;
    // getter setters
}

class SuperClass extends AbstractClass<SuperClass> {
    private String name;
    // getter setters
}

class SubClass extends AbstractClass<SubClass> {
    private String email;
    // getter setter
}