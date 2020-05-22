private final Collection<SseEmitter> emitters = Collections.synchronizedCollection(new HashSet<SseEmitter>());

public void register(SseEmitter emitter) {
    emitter.onTimeout(() -> timeout(emitter));
    emitter.onCompletion(() -> complete(emitter));

    emitters.add(emitter);
}

private void complete(SseEmitter emitter) {
    System.out.println("emitter completed");
    emitters.remove(emitter);
}

private void timeout(SseEmitter emitter) {
    System.out.println("emitter timeout");
    emitters.remove(emitter);
}

@Scheduled(fixedDelay = 3000)
public void sendSseEventsToUI() { //your model class
    for(SseEmitter emitter : emitters) {
        try {
            emitter.send(UUID.randomUUID().toString(), MediaType.APPLICATION_JSON);
        } catch (Throwable e) {
            emitter.complete();
        }
    };
}