@Controller
public class EditorController {
  @RequestMapping("/editor/*")
  @GET
  public String doGet() {
    return "editor/index.html";
}