public void sendData(byte[] dataToSend) throws IOException {
    try {
        sendLock.lock();

        int dataLength = dataToSend.length;
        dout.writeInt(dataLength);
        dout.write(dataToSend, 0, dataLength);
        dout.flush();
    }
    finally {
         sendLock.unlock();
    }
}