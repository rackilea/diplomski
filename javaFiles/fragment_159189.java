import java.util.ResourceBundle;

public class MyLocalizedThrowable extends Throwable {

    ResourceBundle labels = ResourceBundle.getBundle("loc.exc.test.message");

    private static final long serialVersionUID = 1L;
    public MyLocalizedThrowable(String messageKey) {
        super(messageKey);
    }

    public String getLocalizedMessage() {
        return labels.getString(getMessage());
    }
}