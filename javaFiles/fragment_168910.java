@Controller
public class Status {
    @RequestMapping(value = "/", method = GET, headers = "Connection!=Upgrade")
    public String status() {
        return "OK";
    }
}