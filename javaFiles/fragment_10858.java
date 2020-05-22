String output = "Sorry, we don't recognize that command. Available commands are: 'subscribe' or 'unsubscribe'.";

if (message.startsWith(SUBSCRIBE_COMMAND) || message.startsWith(UNSUBSCRIBE_COMMAND)) {
    subscriber.setSubscribed(message.startsWith(SUBSCRIBE_COMMAND));
    repository.update(subscriber);
    if (!subscriber.isSubscribed())
        output = "You have unsubscribed from notifications. Textt 'subscribe' to start receiving updates again";
    else
        output = "You are now subscribed for updates.";
}
return output;