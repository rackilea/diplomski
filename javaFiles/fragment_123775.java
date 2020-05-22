class C<T extends A> { 
    T a; 
    C(T a) { 
        this.a = a; 
    }
    ...
}

class D extends C<B> {    
    D(B b) {
        super(b);
    }
    ...
}