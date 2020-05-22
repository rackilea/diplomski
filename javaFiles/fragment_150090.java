....
 static ChannelGroup allClientChannels = new DefaultChannelGroup();


 @Override
public void OnConnect(INSIOClient client) {
    System.out.println("A user connected :: " + client.getSessionID());
            client.send("Hey you are connected to myhope.com");

   allClientChannels.add(client.getCTX().getChannel());
}


@Override
public void OnDisconnect(INSIOClient client) {
    System.out.println("A user disconnected :: " + client.getSessionID() + " :: hope it was fun");
    allClientChannels.remove(client.getCTX().getChannel());

}