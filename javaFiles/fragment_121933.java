public A() {                                            <---
    foo(); //overriden version in class B is called        |
}                                                          |
                                                           |
public B() {                                               |
    // Static fields are already initialized               |
    // Instance fields are not yet initialized             |
    // Here super() is called implicitly which calls A() ---
    // Instance fields are now initialized to respective values
    foo();
}