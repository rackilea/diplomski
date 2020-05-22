while(counter < 10){
    packet = new PacketType(); //change here and try once.
    packet = con.fillWIMPacket(packet);
    packetQueue.add(packet); 
    System.out.println("Packet " + counter + " added to Queue");
    System.out.println("Packet " + counter + " " + packet.toString());
    counter++;
}