import javax.xml.bind.ValidationEvent;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

public class MyValidationEventHandler extends DefaultValidationEventHandler {    
    @Override
    public boolean handleEvent(ValidationEvent event) {
        if (event.getSeverity() == ValidationEvent.WARNING) {
            return super.handleEvent(event);
        } else {
            throw new RuntimeException("My custom message");
        }
    }
}