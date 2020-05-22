Type = Bitstream.readInt(5)
Prototype = PacketHolder.getPrototypeForPacketType(Type)

ReceivedPacket OfReceivedPacket = Prototype.deserilize(Bitstream)

// we need here a switch/if statement to determine how to handle the reading of the data
switch(Type)
{
  case 0: // PacketEnemy00