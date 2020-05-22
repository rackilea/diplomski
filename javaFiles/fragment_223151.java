@Controller
@RequestMapping(value = "/system/**")
public class InformationController {

@Autowired
InformationModel informationModel;

@RequestMapping(value = "/classing/{id}", method = RequestMethod.GET)
public ModelAndView getBaleClassing(@PathVariable String id, Model model, HttpServletRequest request) {
    LOG.info("In the system classing...");
    model.addAttribute("informationModelVO",informationModel.getResult(id));
    return new ModelAndView(SYSTEM_CLASSING_TILE);
}

}