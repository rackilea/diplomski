public class X {

    // no default constructor defined so
    // compiler adds implicit default constructor here: public X(){}

}

public class Y extends X {

    // explicitly declared default-constructor for class Y
    public Y() {
         // compiler automatically calls implicit X default constructor here
         System.out.println("constructing a Y instance");
    }

    // explicitly declared constructor which overloads the default constructor for Y
    public Y(String s) {
        // compiler automatically calls implicit X default constructor here
        System.out.println("constructing a Y instance with param " + s);
    }

}

public class Z extends Y {

    // explicitly declared default constructor for Z
    public Z() {
        super("Z");    // explicitly call the non-default constructor in Y here
        System.out.println("constructing a Z instance"); 
    }

}