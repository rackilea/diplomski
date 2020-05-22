private final List<SseEmitter> sseEmitter = new LinkedList<>();

@RequestMapping (path = "/register", method = RequestMethod.GET)
public SseEmitter register() throws IOException {
    log.info("Registering a stream.");

    SseEmitter emitter = new SseEmitter();

    synchronized (sseEmitter) {
        sseEmitter.add(emitter);
    }
    emitter.onCompletion(() -> sseEmitter.remove(emitter));

    return emitter;
}