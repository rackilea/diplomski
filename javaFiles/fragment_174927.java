//opens an offline pcap file 
Pcap pcap = Pcap.openOffline(pcapIpFile, errbuf); 

//packet object
PcapPacket packet = new PcapPacket(JMemory.POINTER); 

Payload pl = new Payload();

pcap.nextEx(packet);       // retrieves the next packet from input loop thru until eof

if(packet.hasHeader(pl))  //this will check for and retrieve the payload
    pl.data()   // this will give you the data in the payload as a byte stream