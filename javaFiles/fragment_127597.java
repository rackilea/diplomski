abstract class Foo<T>{
    T value;

    T getValue(){
        return value;
    }

    void setValue(T value){
        this.value=value;
    }

    // return whatever is appropriate for all implementations
    abstract Object baz(); 
}

class IntFoo implements Foo<Integer>{
    Object baz(){
        return null // something useful;
    }
}

Collection<Foo<?>> foos = bar.getAllFoo();
for(Foo<?> foo:foos){
    foo.baz();
}