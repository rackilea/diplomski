@Controller
public class MySubscribeController {

    private static final Logger logger = LoggerFactory.getLogger(MySubscribeController.class);

    @AutoWired
    MyDAO dao;

    @RequestMapping(value = "/workbasket/subscribe", method = RequestMethod.POST)
    public @ResponseBody String subWorkBasket(@RequestBody WorkbasketRequest subWorkbasket)  {  
        logger.info("Workbasket");
        //new FuseboxPush(subWorkbasket);
        dao.getWorkbasketResponse();
        return "{result:\"true\"}";     
    }
}