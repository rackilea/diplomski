import org.springframework.ui.Model;

@RequestMapping(value = "/front", method = RequestMethod.GET)
public String onemethod(Model model) throws IOException, ParseException {
    String str = "something";
    model.addAttribute("str", str);
    return "jsppage";
}