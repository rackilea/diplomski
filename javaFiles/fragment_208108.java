@Override
public void modifyHandshake(ServerEndpointConfig config,
                            HandshakeRequest request,
                            HandshakeResponse response)
{
    HttpSession theSession = (HttpSession) request.getHttpSession();
    config.getUserProperties().put(HttpSession.class.getName(), theSession);

    String ID = request.getHeaders().get("x-forwarded-for").get(0);

    if (ChatroomServerEndpoint.users.containsKey(ID))
    {

        // if this user isn't new, add them back onto the list
        User oldUser = ChatroomServerEndpoint.users.get(ID);
        System.out.println("An old user with " + ID + " has returned.");
        ChatroomServerEndpoint.users.remove(oldUser);
        ChatroomServerEndpoint.users.put(ID, oldUser);
        oldUser.toggleConnection(true);
        System.out.println(oldUser + ", " + ChatroomServerEndpoint.users.size() );

    }
    else
    {
        // add a new user to the list
        System.out.println("A new user with ID " + ID + " has arrived!");
        User newUser = new User(ID);
        ChatroomServerEndpoint.users.put(ID, newUser);
        System.out.println(newUser + ", " + ChatroomServerEndpoint.users.size() );
    }

    // put this ID into the configuration for proof of concept
    config.getUserProperties().put("newUser", ID);
}