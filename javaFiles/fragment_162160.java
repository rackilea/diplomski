@Route("contact")
public class ContactPage extends ... implements HasUrlParameter<Long> {
...
    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        if (parameter != null) {
            // Load additional info
        } else {
            Notfication.show("Blablabla");
            // Or
            event.rerouteToError(someError);
        }
    }