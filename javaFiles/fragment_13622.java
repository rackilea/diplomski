@Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    public void greeting(Message message) throws Exception {

     this.template.convertAndSend("/topic/"+message.getFrom_user_id(),message);

    }