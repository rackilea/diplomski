private byte[] getRequestTypeAnnounce(AnnounceUDPWrapper announceUDPWrapper) {
    //long connectionId, int transactionId, int tcpPort
    ByteBuffer bBuffer = ByteBuffer.allocate(98);
    bBuffer.putLong(announceUDPWrapper.a_ConnectionId);
    bBuffer.putInt(ACTION_ID_ANNOUNCE);
    bBuffer.putInt(announceUDPWrapper.a_TransactionId);
    bBuffer.put(announceUDPWrapper.a_InfoHash);//<<<< what you asked.. adding the infoHash which is byte[]
    bBuffer.put(this.m_MyId);

    bBuffer.putLong(announceUDPWrapper.a_Downloaded);
    bBuffer.putLong(announceUDPWrapper.a_Uploaded);
    bBuffer.putLong(announceUDPWrapper.a_Left);
    bBuffer.putInt(announceUDPWrapper.a_EventType.ordinal());

    bBuffer.put(Utils.intToByteArray(0));// ip, 0 = default
    bBuffer.putInt(0);//key
    bBuffer.putInt(10);//num_want

    byte[] portAsBytes = Utils.intToByteArray(announceUDPWrapper.a_ListeningTCPPort);
    bBuffer.put(Utils.subArray(portAsBytes, 2, 2)); //port
    return bBuffer.array();
}