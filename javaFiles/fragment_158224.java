public void processPacket(Packet pkt) {
   DelayInformation delay = (DelayInformation)pkg.getExtension("x", "jabber:x:delay");
   if (delay != null)
      return; //Discard this packet
   delay = (DelayInformation)pkg.getExtension("x", "urn:xmpp:delay");
   if (delay != null)
      return; //Discard this as well
   //Otherwise this is a good packet
   ...
}