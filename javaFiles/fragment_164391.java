@RequestMapping
public String handleRequestWithAllHeaders (@RequestHeader Map<String, String> header,
                                           Model model) {
    model.addAttribute("msg", "Trade request with all headers " + headers);
    return "my-page";
}