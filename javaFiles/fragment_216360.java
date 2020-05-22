public class B {
    static Object something = new Object();
    public static void main(String[] args) { 
        test(); 
    }
    private static Object test() {
        boolean condition = true;
        if (condition) { 
            return something; 
        }
        dosomething();
        return null;
    }
    private static void dosomething() {}
}