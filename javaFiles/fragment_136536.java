@Controller
@RequestMapping("/run/lob")
public class OnDemandControllerForLob {

    @Autowired
    private OnDemandService onDemandService;

    @RequestMapping(value="get",method=RequestMethod.GET)
    @Produces({MediaType.APPLICATION_JSON})
    public @ResponseBody String processOndemandService(@Context 
    HttpServletRequest request,  @Context HttpServletResponse response) {

        //here is a method call that takes lot of time to execute
        // OnDemand.processtherequest();
          onDemandService.processTheRequest();

    return "your request is served";
    }
}