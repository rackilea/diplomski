@RequestMapping(value = {"hello/{id}"}, method = RequestMethod.GET)
public String helloGet(Model model, @PathVariable Integer id) {

    final String url = "http://www.google.com"
    model.addAttribute("externalUrl", url);

    return "hello";
}