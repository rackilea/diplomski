@ControllerAdvice(assignableTypes = AController.class)
public class AControllerAdvice {
    @ModelAttribute
    public void addModelInformation(Model model){
         //controller specific model information for header and footer added here
    }
}