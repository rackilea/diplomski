synchronized(mutex) {
    data = event.getAsciiString();
    if (awaitingEcho && data.contains(expectedEcho)) {
        transmitEnable.low();
        data = data.replace(expectedEcho, EMPTY);
        expectedEcho = null;
    }
}