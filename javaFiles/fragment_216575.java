MyInterface myInterface = new MyInterface() {

    public void doStuff() {
        //here is your implementation
    }

    public void doAnotherStuff() {
        //Note that this method is public, but
        //you're still not able to call it from outside of this class
        //because it's not part of MyInterface's contract
    }
};