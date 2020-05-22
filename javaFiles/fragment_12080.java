public abstract class GenericController<T> {
    @RequestMapping("/edit")  
    public ModelAndView edit(@ModelAttribute("t") T t) { ... }
}

@Controller @RequestMapping("/foo")
public class FooController extends GenericController<Foo> { ... }