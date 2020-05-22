packet = avcodec.av_packet_alloc();
    packet.pts(pts);
    packet.dts(dts);
    packet.flags(flags);

    Pointer newDataPointer =  avutil.av_malloc(dataSize);
    BytePointer dataPointer = new BytePointer(newDataPointer);
    dataPointer.put(dataBytes);
    packet.data(dataPointer);
    packet.size(dataSize);

    Pointer newSidePointer = avutil.av_malloc(sideSize);
    BytePointer sidePointer = new BytePointer(newSidePointer);
    sidePointer.put(sideBytes);

    BytePointer sideDataPointer = avcodec.av_packet_new_side_data(packet, sideType, sideSize);
    AVPacketSideData sideData = new AVPacketSideData(sideDataPointer);
    sideData.data(sidePointer);
    sideData.type(sideType);
    sideData.size(sideSize);
    packet.side_data(sideData);
    packet.side_data_elems(sideElements);