byte[] fileInBytes = new byte[1500];
BufferedInputStream in = new BufferedInputStream(new    
                                        FileInputStream(fileName));

while((bytesRead = in.read(fileInBytes)) != -1) {
        byte[] packetBytes = Arrays.copyOf(fileInBytes, bytesRead);
        Sender.enqueue(new Packet(seq, packetBytes );
        seq++;
}