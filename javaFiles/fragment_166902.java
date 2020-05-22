class Gen<T extends Base> { //this class uses bounded generics
    T o;
    void set(T o){ this.o = o; }
    T get(){ return o; }
}
class LSP{              // this class uses LSP
    Base o;
    void set(Base o){ this.o = o; }
    Base get(){ return o; }
}