@Service
public class GetPlayer
{
    @Session
    private LocalSession sender;

    @Listener("/service/player/get")
    public void perform(ServerSession session, ServerMessage message)
    {
        Map<String, Object> player = retrievePlayerInfo(message.get("playerId"));
        session.deliver(sender, message.getChannel(), player);
    }
}