try{
    while(true){
        lock.lock();
        s.receive(packet);
        p.parseUDP(packet.getData());
    } 
}finally {
    lock.unlock();
}