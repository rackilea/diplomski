@ControllerAdvice
class Advice {

    @ModelAttribute
    public void everyRequest(Model model) {
        model.addAttribute("default", true);
    }

}