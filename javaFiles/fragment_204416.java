@RequestMapping(value = "/", method = RequestMethod.GET)
public String getHomePage(Model model, @ModelAttribute("processingException") Object processingException) {                

    if (processingException instanceof ErrorResponse) {
        model.addAttribute("processingException", ((ErrorResponse) processingException).getError());
    } else {
        model.addAttribute("processingException", null);
    }
    return "upscale"; //here upscale.html redirection       
}