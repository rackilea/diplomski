There is an alternative to static blocks — you can write a private static method:

class Whatever {
    public static varType myVar = initializeClassVariable();

    private static varType initializeClassVariable() {

        // initialization code goes here
    }
}

The advantage of private static methods is that they can be reused later if you need to reinitialize the class variable.