import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogsController {

    @RequestMapping("/blogs")
    public String index(ModelMap model) {
        model.addAttribute("blog", new Blog("foobar"));
        return "blogs/index";
    }    
}