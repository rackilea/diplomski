@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.POST, value = "math")
    @ResponseBody
    public Result math(@RequestBody final Request request) {
        final Result result = new Result();
        result.setAddition(request.getLeft() + request.getRight());
        result.setSubtraction(request.getLeft() - request.getRight());
        result.setMultiplication(request.getLeft() * request.getRight());
        return result;
    }

}