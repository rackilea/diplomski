@Controller
@RequestMapping(value = "{version}/test")
class TestController {

    @RequestMapping(value="/something")
    public ModelAndView doSomething(@PathVariable String version) {
       // do something here with the version
    }

}