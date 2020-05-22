if(dis.read() == 0x01) {
    int zeroesInARow = 0;

    while(zeroesInARow < 2) {
        int b = dis.read()
        if(b == 0x00) zeroesInARow++;
        else zeroesInARow = 0;
        buf.write(b);
    }
    String rawMessage = new String(buf.toArray());
    // take off the last two 0s
    String messageRecevied = rawMessage.substring(0,rawMessage.length()-2);
    return messageRecevied;
}