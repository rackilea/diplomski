@Controller
public class GreetingController {

    @Autowired
    private AnimalBean ab;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public AnimalInfogreeting(HelloMessage message) throws Exception {
        return new AnimalInfo(ab.getCows(), ab.getRabbits());
    }

}