// Same as above but with default constructor included explicitly
public class Outer {
    class Inner1 extends Outer  { 
        Inner1() { super(); }
    }
    class Inner2 extends Inner1 {
        Inner2() { super(); }    
    }
}
// STILL DOES NOT COMPILE!!