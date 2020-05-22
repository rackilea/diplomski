@Controller
public class QueueController {

    @SubscribeMapping("/notificator")
    public String getNotificatorQueue(Principal principal) {
        String role = // get role from principal
        return "/topic/notificator/" + role;
    }

}