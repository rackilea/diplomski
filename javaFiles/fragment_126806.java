int dataSize = packet.size();
    ByteBuffer dataBuffer = packet.data().capacity(dataSize).asByteBuffer();
    byte dataBytes[] = new byte[dataSize];
    dataBuffer.get(dataBytes);

    AVPacketSideData sideData = packet.side_data();
    int sideSize = sideData.size();
    ByteBuffer sideBuffer = sideData.data().capacity(sideSize).asByteBuffer();
    byte sideBytes[] = new byte[sideSize];
    sideBuffer.get(sideBytes);

    int sideType = sideData.type();
    int sideElements = packet.side_data_elems();
    long dts = packet.dts();
    long pts = packet.pts();
    int flags = packet.flags();