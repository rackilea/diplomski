@Controller
public class MyController {
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Type.class, new TypeEditor());
  }
}