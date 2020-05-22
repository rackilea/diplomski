public class MyController {

public String controllerMethod(@Valid Customer customer, BindingResult result) {
    if (result.hasErrors()) {
        // process error
    } else {
        // process without errors
    }
}