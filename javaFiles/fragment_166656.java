@Controller
public class HelloWorldController implements ApplicationContextAware  {
    ApplicatonContext ctx = ...;

    @RequestMapping(value="/myProtectedContent")
    public void index(HttpServletRequest req, HttpServletResponse res) {
        Resource resource = ctx.getResource("classpath:staticpath/myjpg.jpg");
        FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
    }
}