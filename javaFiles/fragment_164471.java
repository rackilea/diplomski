public static PacketPlayOutChat createPacketPlayOutChat(String s){return new PacketPlayOutChat(ChatSerializer.a(s));}

public static void SendJsonMessage(Player p, String s){( (CraftPlayer)p ).getHandle().playerConnection.sendPacket( createPacketPlayOutChat(s) );}

public void sendMessage(Player player, String message, String url) {
    SendJsonMessage(player,
        "{text:\"" + message + "\",clickEvent:{action:open_url,value:\"" +
        url + "\"}}");
}