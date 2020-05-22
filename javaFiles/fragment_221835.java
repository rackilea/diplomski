private byte[] getSharedKey() {
    try {
        //XXX:  doesn't seem to be formally specified anywhere, but convention appears to be that the client key always goes first
        P_SHA1 algo = new P_SHA1();
        return algo.createKey(getBinaryClientEntropy(),  //the 'BinarySecret' value that the client sent to the server, decoded to raw binary 
                              getBinaryServerEntropy(),  //the 'BinarySecret' value that the server sent to the client, decoded to raw binary
                              0,                         //offset, '0' is what we want here
                              getSharedKeySize() / 8);   //'KeySize' is 256 bits in this case (specified by server), divide by '8' to convert to bytes
    }
    catch (Throwable e) {
        LOG.error("Unable to compute shared key!", e);
    }

    return null;
}