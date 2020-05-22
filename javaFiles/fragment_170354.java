public abstract class Example {

    protected abstract ErrorCode test();

    public void run() {
       ErrorCode code=test();
       switch(code) {
           case OK: 
               System.out.println("All ok"); 
           break;
           case OOPS: 
               System.out.println("Oops, an error occurred.");
           break;
           case OTHER_ERROR: 
               System.out.println("A different error occurred");
           break;
           case UNKNOWN_ERROR: 
               System.out.println("Yet another, unknown error occurred.");
           break;
       }
    }

    public static enum ErrorCode {
        OK, OOPS, OTHER_ERROR, UNKNOWN_ERROR;
    }
}