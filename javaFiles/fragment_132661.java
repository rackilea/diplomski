private static Packet readPacket(InputStream is) throws Exception {
    int ch;
    Packet p = new Packet();

    StringBuilder type = new StringBuilder();
    while((ch = is.read()) != 44) {
        if(ch == -1)
            throw new IOException("EOF");
        // NOTE: conversion from byte to char here is iffy, this works for ISO8859-1/US-ASCII
        // but fails horribly for UTF etc.
        type.append((char) ch);
    }
    String data = type.toString();
    ...
}