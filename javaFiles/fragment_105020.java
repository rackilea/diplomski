//...
private SseEmitter emitter;

@RequestMapping(value = "/{imei}", method = RequestMethod.GET)
public User getUser(@PathVariable String imei) { 
    User myUser = null;

    // .. do resolving of myUser (e.g. database etc).

    // Send message to "connected" web page:
    if (emitter != null) {
        emitter.send(myUser.toString()); // Or format otherwise, e.g. JSON.
    }

    // This return value goes back as a response to your android device
    // i.e. the caller of the getUser rest service.
    return myUser;
}

@RequestMapping(value = "/sse")
public SseEmitter getSseEmitter() {
    emitter = new SseEmitter();
    return emitter;
}