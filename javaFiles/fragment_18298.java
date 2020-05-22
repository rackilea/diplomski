public class btnRunBackup {    
    private String s;

    public String checkStatus() {
        String error = null; // by default no error
          ... do whatever you need to find out the error
              .... 
              error = "error is: xxx ";
        return error; // return null (no error ) or what you found
    }