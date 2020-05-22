public abstract Class A {
     private final Enumeration e;

     protected A (Enumeration e) {
         this.e = e;
     }

     public void someMethod {
           // do something with 'e'.
     }
}

public Class B extends A {
    public B() {
        super(Enumeration.A);
    }
}