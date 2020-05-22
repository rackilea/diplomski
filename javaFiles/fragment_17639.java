@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @JsonView(View.Summary.class)
    @RequestMapping("/messageSummaryOnly")
    public List<Message> getAllMessages() {
        return messageService.getAll();
    }
}