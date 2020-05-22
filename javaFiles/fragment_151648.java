@Controller
public class MainController {

    @RequestMapping(value = "/kill/{killCode}", method = RequestMethod.GET)
    public void killAll(@PathVariable String killCode) {
        if (Objects.equals(killCode, "lsjfkldsjf56564k"))
        killAll(killCode);
    }

}