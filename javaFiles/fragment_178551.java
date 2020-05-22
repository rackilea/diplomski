// Note the absense of @Controller to prevent this controller
// from being discovered by DefaultAnnotationHandlerMapping
public class FooController {
    @RequestMapping("/list") public String list(...) { ... }
    @ReqeustMapping("/save") public String save(...) { ... }
}