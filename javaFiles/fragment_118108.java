/**
 * This will prompt for a user name, after which it will send info about the conversation.  After sending
 * information, the cycle restarts.
 *
 * @param turnContext The context object for this turn.
 * @return A future task.
 */
@Override
protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
    // Get state data from UserState.
    StatePropertyAccessor<WelcomeUserState> stateAccessor = userState.createProperty("WelcomeUserState");
    CompletableFuture<WelcomeUserState> stateFuture = stateAccessor.get(turnContext, WelcomeUserState::new);

    return stateFuture.thenApply(thisUserState -> {
        if (!thisUserState.getDidBotWelcomeUser()) {
            thisUserState.setDidBotWelcomeUser(true);

            String userName = turnContext.getActivity().getFrom().getName();
            return turnContext.sendActivities(
                MessageFactory.text(FIRST_WELCOME_ONE),
                MessageFactory.text(String.format(FIRST_WELCOME_TWO, userName))
            );
        } else {
            String text = turnContext.getActivity().getText().toLowerCase();
            switch (text) {
                case "hello":
                case "hi":
                    return turnContext.sendActivities(MessageFactory.text("You said " + text));

                case "intro":
                case "help":
                    return sendIntroCard(turnContext);

                default:
                    return turnContext.sendActivity(WELCOMEMESSAGE);
            }
        }
    })
        // make the return value happy.
        .thenApply(resourceResponse -> null);
}