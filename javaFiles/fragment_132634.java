public class Error {
    private String statusCode;
    private String message;
    private List<String> errors;
    private Date date;

    public Error(String status, String message) {
        this.statusCode = status;
        this.message = message;
    }

    //Getters - Setters 
}