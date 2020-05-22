// this class has no mapping
public abstract class MyAbstractController() {
  @Autowired
  MyService service

  public String _display(Model model, ...) {
    // here is the implementation of display with all necessary parameters
    if(determine(..)){...}
    else {...}
  }

  // this determines the behavior of sub class
  public abstract boolean determin(...);
}

@Controller
@RequestMapping(...)
public class MyController1 extends MyAbstractController {

  @RequestMapping("context/mapping1")
  public String display(Model model, ...) {
    // you just pass all necessary parameters to super class, it will process them and give you the view back.
    return super._display(model, ...);
  }

  @Override
  public boolean determine(...) {
  // your logic for this 
  }
}

@Controller
@RequestMapping(...)
public class MyController2 extends MyAbstractController {

  @RequestMapping("context/mapping2")
  public String display(Model model, ...) {
    // you just pass all necessary parameters to super class, it will process them and give you the view back.
    return super._display(model, ...);
  }

  @Override
  public boolean determine(...) {
  // your logic for this 
  }
}