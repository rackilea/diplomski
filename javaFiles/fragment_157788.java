do {
    try {
        receiveLength = inStream.read(buff, 0, length);
    } catch (Exception e) {
        e.printStackTrace();
    }
} while (receiveLength <= 0);