import org.jibble.pircbot.*;

public class MyBot extends PircBot {

  public MyBot() {
    this.setName("MyBot");
  }

  public void onJoin(String channel, String sender,
                   String login, String hostname, String message) {
    this.voice(channel, sender);
  }

  public void voiceAll(String channel) {
    int i = 0;
    User[] users = this.getUsers(channel);
    while (i < users.length)
      this.voice(channel, users[i++].getNick());
  }
}

public class MyBotMain {

  public static void main(String[] args) throws Exception {
    MyBot bot = new MyBot();
    bot.connect("irc.freenode.net");
    bot.joinChannel("#chan");
    bot.voiceAll("#chan"); 
  }

}