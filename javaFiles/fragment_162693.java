PcapPacket packet = //get from somewhere
Tcp tcp = new Tcp();
Ip4 ip = new IP4();
byte[] sIP = new byte[4];
byte[] dIP = new byte[4];
String sourceIP = "";
String destIP = "";

if(packet.hasHeader(ip) && packet.hasHeader(tcp)){
   sIP = packet.getHeader(ip).source();
   sourceIP = org.jnetpcap.packet.format.FormatUtils.ip(sIP);
   dIP = packet.getHeader(ip).destination();
   destIP = org.jnetpcap.packet.format.FormatUtils.ip(dIP);

   System.out.println("*" + sourceIP + "*" + destIP);
   System.out.println("Source IP" + sourceIP);
   System.out.println("Destination IP" + destIP);

   if(tcp.source() == 80){
      System.out.println("HTTP protocol");
   } else if(tcp.source == 23) {
      System.out.println("Telnet protocol");
   }
}