public class MyStatus {
    private String status;
    private String message;
    public MyStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public String getStatus() {
        return this.status;
    }
    public String getMessage() {
        return this.message;
    }
}