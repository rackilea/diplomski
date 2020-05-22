ChannelFuture lastFuture = null;
for (;;) {
    byte[] bytes = new byte[readLength];
    int readNum = bis.read(bytes, 0, readLength);
    // System.out.println(readNum);
    if (readNum == -1) {
        bis.close();
        fis.close();
        if(lastFuture == null) { // When our file is 0 bytes long, this is true
            channel.close();
        } else {
            lastFuture.addListener(ChannelFutureListener.CLOSE);
        }
        return;
    }
    lastFuture = sendToServer(bytes, channel, readNum);
}