@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    //@Qualifier("clientService")
    public void setClientService(ClientService clientService){
        this.clientService=clientService;
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String reg(Model model){
        model.addAttribute("client", new Client());
        return "registration";
    }

    @RequestMapping(value = "registration/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute Client client){
        this.clientService.addClient(client);
    return "home";
    }
}