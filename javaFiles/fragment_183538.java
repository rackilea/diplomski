public void initialize(){
    EmitterProcessor<Event> emitter = ...
    emitter.flatMap(eventForScope ->
        Mono.just(eventForScope)
            .flatmap(this::step1)
            .flatmap(this::step2)
            .flatmap(this::finalStep)
            .subscriberContext(...) //context for ONE event
        )
        .subscribe()
}