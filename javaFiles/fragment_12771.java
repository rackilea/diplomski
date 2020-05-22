@Controller
@RequestMapping("/")
public class ImportController{

    @RequestMapping(value = "a.html", method = RequestMethod.GET)
    public ModelAndView getA(HttpServletRequest req) {
        ModelAndView mv;
        mv = new ModelAndView("a");
        return mv;
    }

    @RequestMapping(value = "b.html", method = RequestMethod.GET)
    public ModelAndView getB(HttpServletRequest req) {
        ModelAndView mv;
        mv = new ModelAndView("b");
        return mv;
    }

    @RequestMapping(value = "c.html", method = RequestMethod.GET)
    public ModelAndView getC(HttpServletRequest req) {
        ModelAndView mv;
        mv = new ModelAndView("c");
        return mv;
    }

@RequestMapping(value="**",method = RequestMethod.GET)
public String getAnythingelse(){
return "redirect:/404.html";
}