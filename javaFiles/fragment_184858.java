@RestController("my/path")
public class MyController {
    @RequestMapping(method = RequestMethod.GET)
    public void myPath(@RequestParam(value = "x") float x,   @RequestParam(value = "y") float y) {
    //Your code here
    }
}