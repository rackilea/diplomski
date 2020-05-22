@RequestMapping(path = "/hello", method = RequestMethod.GET)
public String printHello(Model model, @ModelAttribute("form") SearchForm form, BindingResult result) {
    model.addAttribute("anotherUsefulValue", myService.getSomeValue());
    // 'hello' view will get the model with both 'form' and 'anotherUsefulValue' attributes
    // and 'form' attribute will have 'text' field filled from request's
    // query parameter 'text'.
    return "hello";
}

class SearchForm {
    private String text;
    // ... getter and setter
}