@RequestMapping(value="/stream", method=RequestMethod.GET)
public ResponseBodyEmitter handle() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        // Pass the emitter to another component...
        return emitter;
}

// in another thread
emitter.send(foo1);

// and again
emitter.send(foo2);

// and done
emitter.complete();