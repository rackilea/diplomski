@Controller
@RequestMapping("/counter")
@SessionAttributes("mycounter")
public class CounterController {

  // Checks if there's a model attribute 'mycounter', if not create a new one.
  // Since 'mycounter' is labelled as session attribute it will be persisted to
  // HttpSession
  @RequestMapping(method = GET)
  public String get(Model model) {
    if(!model.containsAttribute("mycounter")) {
      model.addAttribute("mycounter", new MyCounter(0));
    }
    return "counter";
  }

  // Obtain 'mycounter' object for this user's session and increment it
  @RequestMapping(method = POST)
  public String post(@ModelAttribute("mycounter") MyCounter myCounter) {
    myCounter.increment();
    return "redirect:/counter";
  }
}