class SomeClass<E> {
    void doSomethink(List<Integer> params) { }
}

class AnotherClass {
    public void method() {
        SomeClass<Integer> someClass = new SomeClass<>();
        List<Long> list = new ArrayList<>();

        someClass.doSomethink(list);
    }
}