public class PublishChattMessage
{
   List<chatWithUser> userChatList;

   public void setUpChat(ChatUser mainUser )
  {
     for(ChatWithUser user:userChatList)
     {
         List<ChatUser> userList = user.getFriends()
        // set up connections with all friends
     }
  } 

  /**
   *  Method to chat between two users. u
   **/
  public void chat(ChatUser userOne,ChatUser user2)
  {

  }
}