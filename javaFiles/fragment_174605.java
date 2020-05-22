public class SomeClass {

    int stock1; // declares the class member that lives inside the class

    public void someMethod() {
        int stock1; // declares a new local variable only living inside the method
        stock1 = 5; // writes to the local variable
        this.stock1 = 6; // writes to the class member of the same name
        this.stock1 = stock1; // stores the value of the local variable in the class member
    }

}