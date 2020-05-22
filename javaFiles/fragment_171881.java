@Controller
public class SomeController {


    @Autowired
    EngineerService engineerService;

    @Autowired
    OtherService otherService;

    @MessageMapping("/saveSomething")
    public String saveSomething(@AuthenticationPrincipal Principal user, String input){
        String userName = user.getName();
        Engineer engineer = engineerService.getByLogin(userName);
        otherService.SaveNewEntity(input, engineer);
        return "trigger";
    }
}