public class Foo {
    private final Collection<object> collection;

    public void Foo(Collection<object> collection) {
       this.collection = collection;
    }

    public synchronized add(Object o) {
       this.collection.add(o);
    }
}

public class Bar {
    private final Collection<object> collection;

    public void Bar(Collection<object> collection) {
       this.collection = collection;
    }

    public synchronized print() {
       for (Object o : collection) { System.out.println(o); }
    }
}