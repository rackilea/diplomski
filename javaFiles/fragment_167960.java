@Controller
@RequestMapping("/basic")
public class HelloWorldController {
    @RequestMapping(value="/hello.do", method=RequestMethod.GET)
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("basic/helloWorld");
        mav.addObject("message", "Hello World From Phuong!");
        return mav;
    }
}