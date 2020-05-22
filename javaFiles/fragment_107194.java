@Controller
@RequestMapping("/foo")
public class FooController {

  @Autowired
  private FooRepository fooRepository;

  @RequestMapping
  String getFoos(Model model) {

    List<Foo> foos = fooRepository.findAll();
    model.addAttribute("foos", foos);

    model.addAttribute("someOtherDataYourViewNeeds", "bar");

    return "foo/list";

  }

}