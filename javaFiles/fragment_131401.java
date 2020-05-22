private static void send(DatagramPacket sent) throws Exception{
    try{
        socket.send(sent);
    }catch(RuntimeException e){
         throw e;
    }catch(Exception e){
         throw new RuntimeException("error sending package through socket", e);
    }
}