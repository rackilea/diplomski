@Component
public class LabsValidator {

    public void validatePractices(final Labs labs,final ValidationContext context) {
        if(labs.getPractices().size() < 15) {
            context.getMessageContext().addMessage(new MessageBuilder().error().code("labs.practices.min15").build());
        }
    }

}