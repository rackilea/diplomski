public class MainView extends ... {

    // Existing Code

    @Autowired
    private MessageServiceImpl messageService;

    @Scheduled(fixedRate = 1000)
    public void execute() {
        messageService.getAllMessages();
    }

}