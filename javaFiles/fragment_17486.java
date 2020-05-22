while(true) {
    s.receive(packet);
    try {
        lock.lock();
        s.parseUDP(packet.getData());
    } finally {
        lock.unlock();
    }
}