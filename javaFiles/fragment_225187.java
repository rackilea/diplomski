public class C<T>{
    protected T x;
}

public class D extends C<SomeConcreteType>{
     //x will be SomeConcreteType
}