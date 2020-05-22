class Tuple1<A> { 
    private final A a; 
    public Tuple1(A a) { 
        this.a = a; 
    } 
}

class Tuple2<A, B> { 
    private final A a; 
    private final B b; 
    public Tuple2(A a, B b) { 
        this.a = a; 
        this.b = b; 
    } 
}

class Tuple3<A, B, C> { 
    private final A a; 
    private final B b; 
    private final C c;
    public Tuple3(A a, B b, C c) { 
        this.a = a; 
        this.b = b;
        this.c = c; 
    } 
}

...