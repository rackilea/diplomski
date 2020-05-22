class Packet {
    int seq;
    byte[] data;

    public Packet(int seq, byte[] data) {
       this.seq = seq;
       this.data = data;
   }
}