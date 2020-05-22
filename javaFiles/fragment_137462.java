class Packet
{
    private byte    header;
    private byte    commandCode;
    private int     sequenceNumber;
    private boolean ackStatus;

    void    write(DataOutput out) throws IOException
    {
        int wirePacket = header|(commandCode << 4)|(sequenceNumber << 8);
        if (ackStatus)
        {
            wirePacket |= 0x80000000;
        }
        out.writeInt(wirePacket);
    }

    static Packet   read(DataInput in) throws IOException
    {
        Packet  packet = new Packet();
        int wirePacket = in.readInt();
        packet.header = (byte)(wirePacket & 0x0f);
        packet.commandCode = (byte)((wirePacket >>> 4) & 0x0f);
        packet.sequenceNumber = (wirePacket >>> 8) & 0x7FFFFF;
        packet.ackStatus = (wirePacket & 0x80000000) != 0;
        return packet;
    }
    // getters and setters. The setters must ensure that the values don't go out of range.
}