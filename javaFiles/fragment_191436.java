@Controller
public class MyController {

  @Autowired private Marshaller marshaller;

  @RequestMapping("/helloxml")
  public MarshallingView helloxml(Model model) {
    MyMessage msg = new MyMessage();
    msg.setMessage("hello world");
    model.addAttribute("msg", msg);

    MarshallingView marshallingView = new MarshallingView(marshaller);
    marshallingView.setModelKey("msg"); // set what model attribute to display as xml

    return marshallingView;
  }
}