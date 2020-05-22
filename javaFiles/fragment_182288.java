private static User newUser;

@Override
public void onGuildMemberJoin(GuildMemberJoinEvent event) {

    newUser = event.getUser();

}

@Override
public void onMessageReceived(MessageReceivedEvent event) {

    System.out.println(newUser.getName()); //...your code

}