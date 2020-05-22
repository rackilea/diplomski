public class MyException extends RuntimeException
{
    private String type = null;
    private String severity = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public MyException(String message) {
        super(message);
    }
}