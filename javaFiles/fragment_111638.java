@Autowired
public PushController(PushService service) {
    this.service = service;
}

@RequestMapping(path = "/", method = RequestMethod.GET)
public SseEmitter stream() {
    final SseEmitter emitter = new SseEmitter(0L);
    service.register(emitter);
    return emitter;
}