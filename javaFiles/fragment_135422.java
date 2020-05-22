@Controller
public class DemoController {

 @GetMapping("/create")
 public String create(Model model) {

  model.addAttribute("create", new Demo());
  countriesList(model); // this line is needed
  return "create";

 }

 private void countriesList(Model model) {

  List < String > countryList = new ArrayList < > ();

  countryList.add("US");
  countryList.add("UK");

  model.addAttribute("countries", countryList);

 }
}