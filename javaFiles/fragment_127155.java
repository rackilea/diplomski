@Override
public Object manage(final CommandMessage commandMessage) {
    switch (commandMessage.getOperation()) {
        case CommandMessage.SUBSCRIBE_OPERATION:
                // add user info
                // be aware - each time the selector changes this method is called. So when you add user info check to see if you are not duplicating the clients.
                addInfoAboutUser(commandMessage.getHeader("DSId").toString(), commandMessage.getClientId().toString());
                break;
        case CommandMessage.UNSUBSCRIBE_OPERATION:
                clearUserInfo(commandMessage.getClientId().toString());
                break;
    }
    return null;
}