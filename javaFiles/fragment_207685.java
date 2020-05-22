@Controller
class PagesCtrl {
    @RequestMapping("/index.htm")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index")
        return mav
    }
}