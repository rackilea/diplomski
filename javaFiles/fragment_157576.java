Class1 {
    public static void loadMe() {}
}
class2 {

    public Class2() {
        // Calling a dummy static member for loading the class
        Class1.loadMe();
    }
}