class Example {

    int field;
    int hello = 2; // initialized to 2
    int there;
    Object[] array = new Object[50]; // array initialized here, all elements null

    Example () {
       there = 2; // can also be initialized in constructor
       // initialize each element of array:
       for (int n = 0; n < array.length; ++ n)
           array[n] = new Object();
    }

    void a () {
       int local;
       local = 1; // ok
       field = 1; // ok
       hello = 1; // ok
       there = 1; // ok
    }

    void b () {
       System.out.println(local); // no 'local' declared here
       System.out.println(field); // ok
       System.out.println(hello); // ok
       System.out.println(there); // ok
    }

}