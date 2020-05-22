public class Program {
    public static void main(String[] args) {
        FailingConstructor f2 = null;
        try {
            f2 = new FailingConstructor(-11);
        } catch (E1 e) {
            f2 = new FailingConstructor(); // one way to recover from the exception 
                                           // is to use a different constructor
                                           // that doesn't throw an exception
        }
        // now you can access f2
    }
}