private EventService service;

@Autowired
public EventController(EventService service) {
    this.service = service;
}