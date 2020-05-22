public static List<Message> getSentMessages(long userId) 
{
    User parent = ofy().load().type(User.class).id(userId).now();
    List<Message> results = ofy().load().type(Message.class).ancestor(parent).limit(1000).list();   
    return results;
}