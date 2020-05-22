class Super {
   protected int a;
   protected Super(int a) { this.a = a; }
}

class Sub extends Super {
    public Sub(int a) { super(a); }
    public Sub() { 
       super(0);  // <-- call base constructor
       this.a = 5; 
    }
}