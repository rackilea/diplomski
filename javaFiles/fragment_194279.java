public void run() {
   while (!shutdown) {
      packet = packetQueue.take();
      processPacket(packet);
   }
}