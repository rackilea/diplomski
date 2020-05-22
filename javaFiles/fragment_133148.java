/* packet listener: listen for incoming messages of type CHAT on the connection (whatever the buddy) */
  PacketFilter filter = new MessageTypeFilter(Message.Type.chat); 
  xmppManager.connection.addPacketListener(new PacketListener() { 
    public void processPacket(Packet packet) {
      Message mes = (Message)packet;
      Log.w("***"+mes.toString()+"***","0");
    }
  }, filter);