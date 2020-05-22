@Controller
public class SimpleController {

  @GetMapping("inputbook.html")
  public String inputbook() {
    return "inputbook"; // this returns the template name to be rendered from resources/templates. You don't need to provide the extension.
  }
}