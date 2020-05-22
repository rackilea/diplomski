public class MyException extends Exception {

       public MyException (String message, OrekitException exception){
            super(message, exception);
        }
}