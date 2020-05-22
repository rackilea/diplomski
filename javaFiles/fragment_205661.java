public class ExceptionPrinter {

    public static void printException(Exception e){
        System.err.println("Error message: " + e.getMessage());
        e.printStackTrace();
    }

    public static void printException(Exception e, Class c, String function, String message){
        //System.err.println(class + " " + function + "(): " + message);
        printException(e);
    }
}