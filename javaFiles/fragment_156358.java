interface SingleMethod{ //The single method interface
    void foo(int i);
}

class X implements SingleMethod { //A class implementing it (and probably other ones)
    void foo(int i){...}
}

class Y { //An unrelated class that has methods with matching signature
    void bar(int i){...}
    static void bar2(int i){...}
}

class Framework{ // A framework that uses the interface
    //Takes a single method object and does something with it
    //(probably invoking the method)
    void consume(SingleMethod m){...}
}

class Client{ //Client code that uses the framework
    Framework f = ...;
    X x = new X();
    Y y = new Y();
    f.consume(x); //Fine, also in Java 7

    //Java 8
    //ALL these calls are only possible since SingleMethod has only ONE method!
    f.consume(y::bar); //Simply hand in a method. Object y is bound implicitly
    f.consume(Y::bar2); //Static methods are fine, too
    f.consume(i -> { System.out.println(i); }) //lambda expression. Super concise.

    //This is the only way if the interface has MORE THAN ONE method:
    //Calling Y.bar2 Without that closure stuff (super verbose)
    f.consume(new SingleMethod(){
         @Override void foo(int i){ Y.bar2(i); }
    });
}