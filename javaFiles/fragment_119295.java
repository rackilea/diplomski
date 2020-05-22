class Parent { }

interface MyInterface {
    void foo();
}

class Child extends Parent implements MyInterface {
    @Override
    public void foo() {
        System.out.println("Foo");
    }
}

void main() throws Exception {
    List<Parent> list = new ArrayList<>();
    list.add(new Parent());
    list.add(new Child());
    for (Parent p : list) {
        if (p instanceof MyInterface) {
            MyInterface cased = (MyInterface) p;
            cased.foo();
        }
    }
}