@Controller
@SessionAttributes("readonlySettings")
public class MyController {

@RequestMapping(value = "/firstPage")
public ModelAndView firstPageSubmit(String valuePage1, String valuePage2, ModelMap map) {
    map.addAttribute("readonlySettings", new ReadonlySettings( valuePage1, valuePage2 );
    return new ModelAndView("secondPage");
} 

@RequestMapping(value = "/secondPage")
public ModelAndView secondPage(ModelMap map, SessionStatus status, String valuePage2, ) {
    ReadonlySettings settings = map.getAttribute("readonlySettings");
    doa.save(settings.getValuePage1(), settings.getValuePage2(), valuePage2);
    status.setComplete();
}