public class MyObject {
    private static MyObject instance;
    private MyObject(){}//overrides the default constructor
    public static MyObject sharedMyObject() {
        if (instance == null)
            instance = new MyObject();//calls the private constructor
        return instance;
    }
}