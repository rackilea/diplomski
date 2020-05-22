public Object[] methodA() {
    // We are method A
    // In which we create an array
    Object[] someArrayCreatedInMethodA = new Object[10];
    // And we can returned someArrayCreatedInMethodA
    return someArrayCreatedInMethodA;
}

public void methodB() {
    // Here we are inside another method B
    // And we want to use the array
    // And there is a possibility that we can call the method A inside method B
    Object[] someArrayCreatedAndReturnedByMethodA = methodA();
    // And we have the array created in method A
    // And we can use it here (in method B)
    // Without creating it in method B again
}