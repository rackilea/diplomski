TCPPacket p = (TCPPacket)packet;

// Get the tcp src and dest ports
int destPort = p.dst_port;
int srcPort = p.src_port;

// Get the src and dest IP addresses from the IP layer
InetAddress destIp = p.dst_ip;
InetAddress srcIp = p.src_ip;