public class ClassNotFoundExceptionExample {

    private static final String CLASS_TO_LOAD = "main.java.Utils";

    public static void main(String[] args) {
        try {
            Class loadedClass = Class.forName(CLASS_TO_LOAD);
            System.out.println("Class " + loadedClass + " found successfully!");
        }
        catch (ClassNotFoundException ex) {
            System.err.println("A ClassNotFoundException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}