EventBus eventbus = Bus.getInstance();

ExampleEvent event = eventbus.getStickyEvent(ExampleEvent.class);

    if ( event != null ){

        // Whatever we want to do with event

        // and then we can remove stickyEvent if we don't need it anymore

        eventbus.removeStickyEvent(event);
    }