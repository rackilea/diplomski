InfoStartRPCPacket(
    int apacketId,
    RPCPacketType apacketType,
    RPCOperationType aoperationType,
    String tmpPacket_objectOid,
    int aobjectId,
    int adataSize,
    String tmpPacket_dataHash,
    RPCPacketDataType adataType,
    byte[] apacketData) {
    super(apacketId, apacketType, aoperationType, tmpPacket_objectOid, aobjectId,
            adataSize, tmpPacket_dataHash, adataType, apacketData);
    //your custom constructor code here
}