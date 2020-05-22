@RestController
public class MyServlet {
    @RequestMapping(value = "test", method = {RequestMethod.GET})
    public void testGet(@Valid @RequestParam("foo") String foo) {
          doStuff(foo)
    }
    @RequestMapping(value = "test", method = {RequestMethod.POST})
    public void testPost(@Valid @RequestBody MyReq req) {
          doStuff(req.getFoo());
    }
}