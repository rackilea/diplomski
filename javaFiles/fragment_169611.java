interface X<A extends Y<A, B>, B extends X<A, B>> {

    A getY(); //example    
    Object getO();

}

interface Y<A extends Y<A, B>, B extends X<A, B>> {

    B getX(); //example  
    void doSomething();

}