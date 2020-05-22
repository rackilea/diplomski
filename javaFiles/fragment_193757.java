public void enqueue(Packet...packets)
{ 
  for(Packet packet : packets){
    queue.add(packet);
  }
}