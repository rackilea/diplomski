InterfaceA {
    methodA();
}

class A implements InterfaceA {
   methodA() // implementation
}

InterfaceA getInterface() {
   // some code which returns an object of a class which implements InterfaceA
}