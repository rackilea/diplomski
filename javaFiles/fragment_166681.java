@Controller
// handling methods are relative to this controller
public class ChecklistController {
    private ChecklistService service;
    private static final Log LOG = LogFactory.getLog(ChecklistController.class);

    //Called when you submit data and access it like this.
    @RequestMapping("/checklist")
    public ModelAndView checklist(@ModelAttribute(value="UserSel")UserSel userSel) throws Exception{

        //userSel.get..... you will get submited values like this here. Use your service class here. And return appropriate ModelAndView

        return mavChecklist;
    }

    //Call this method first to get blank jsp. This will bind your dataclass to jsp, in which you will get data once you submit.
     @RequestMapping("/newcheklist")
    public ModelAndView viewRender() {
        ModelAndView mav=new ModelAndView();
        mav.addObject("UserSel ", new UserSel ());
        mav.setViewName("checklist");
        return mav;
    }
    @Autowired
    public void setService(ChecklistService service){
        this.service = service;
    }
}