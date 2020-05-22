class A {
    A() { println("X") }
    A(x,y) { println([x,y]) }
}

// new A // FAILS
// new A 1,2 FAILS

A.newInstance 1,2 // works