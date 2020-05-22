@Component
public class WhistleEventMediator implements ApplicationListener<WhistleEvent> {
    // TODO: make thread safe
    final Set<Consumer<WhistleEvent>> consumers; 

    void subscribe(Consumer<WhistleEvent> c) { ... }

    void unsubscribe(Consumer<WhistleEvent> c) { ... }

    @Override public void onApplicationEvent(WhistleEvent we) {
        // delegate to subscribed consumers
    }
}

@Component 
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class WhateverBean implements Consumer<WhistleEvent> {
    @Inject
    WhistleEventMediator mediator;

    @PostConstruct
    void init() {
        mediator.subscribe(this);
    }

    @PreDestroy
    void destroy() {
        mediator.unsubscribe(this);
    }

    // handle whistle event
}