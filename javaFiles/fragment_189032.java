public StateMachine extends ListenerAdapter {
    private final long messageId;
    private final long userId;
    private final String emoji;

    private int state = 0;

    public StateMachine(...) {...}

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getMessageIdLong() != messageId) return;
        if (event.getUser().getIdLong() != userId) return;
        if (!event.getReactionEmote().getName().equals(emoji)) return;
        switch (state) {
        case 0:
            System.out.println("yes");
            event.getChannel().editMessageById(messageId, ...).queue();
            event.getReaction().removeReaction(event.getUser()).queue();
            state = 1;
            break;
        case 1:
            System.out.println("This is the next awaited event");
            // do something here...
            break;
        }
    }
}