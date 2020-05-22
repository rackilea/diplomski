// "brute-force" fix
public class Outer {
    class Inner1 extends Outer  { 
        Inner1() { super(); }
    }
    class Inner2 extends Inner1 {
        Inner2() { Outer.this.super(); }    
    }
}
// NOW COMPILES!