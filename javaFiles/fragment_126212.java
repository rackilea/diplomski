interface MyInterface extends Comparable<MyInterface> {
    int getX();
    int getY();

    // No need for a compareTo method - we get it from the Comparable interface
}

class A implements MyInterface {
    // No changes required to your implementation
}