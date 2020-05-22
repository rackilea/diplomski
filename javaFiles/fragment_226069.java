class myClass {

    private static int myGlobalVariable;     //Can only be accessed from methods in myClass

    void changeMyVariable (int value) {
        // Data validation here if needed
        this.myGlobalVariable = value;
    }
}