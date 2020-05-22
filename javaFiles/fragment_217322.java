while(true){
    byte buffer[] = new byte[MAX_PDU_SIZE];
    packet = new DatagramPacket(buffer, buffer.length);

    socket.receive(packet);

    Pdu pdu = pduFactory.createPdu(packet.getData());

    if (pdu != null) {
        System.out.print("Got PDU of type: " + pdu.getClass().getName());
        if(pdu instanceof EntityStatePdu){
            EntityID eid = ((EntityStatePdu)pdu).getEntityID();
            Vector3Double position = ((EntityStatePdu)pdu).getEntityLocation();
            System.out.print(" EID:[" + eid.getSite() + ", " + eid.getApplication() + ", " + eid.getEntity() + "] ");
            System.out.print(" Location in DIS coordinates: [" + position.getX() + ", " + position.getY() + ", " + position.getZ() + "]");
            }
        System.out.println();
    }
}