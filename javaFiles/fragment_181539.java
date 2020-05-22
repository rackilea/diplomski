discordClient
    .getEventDispatcher()
    .on(MessageCreateEvent.class)
    .zipWhen(
        event ->
            Mono.just(event)
                .map(MessageCreateEvent::getMessage)
                .map(Message::getContent)
                .filter(Optional::isPresent)
                .map(o -> o.get())
                .map(this::getCommand)
                .filter(Objects::nonNull),
        (event, msg) -> msg.runCommand(event, null))
    .subscribe();