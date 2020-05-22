int buffer = packet.get();
int ipVersion = buffer >> 4;
int headerLength = buffer & 0x0F;   //the number of 32 bit words in the header
headerLength *= 4;
packet.get();                       //DSCP + EN
int totalLength = packet.getChar(); //Total Length
packet.getChar();                   //Identification
packet.getChar();                   //Flags + Fragment Offset
packet.get();                       //Time to Live
int protocol = packet.get();        //Protocol
packet.getChar();                   //Header checksum

String sourceIP  = "";
sourceIP += packet.get() & 0xFF; //Source IP 1st Octet
sourceIP += ".";
sourceIP += packet.get() & 0xFF; //Source IP 2nd Octet
sourceIP += ".";
sourceIP += packet.get() & 0xFF; //Source IP 3rd Octet
sourceIP += ".";
sourceIP += packet.get() & 0xFF; //Source IP 4th Octet

String destIP  = "";
destIP += packet.get() & 0xFF; //Destination IP 1st Octet
destIP += ".";
destIP += packet.get() & 0xFF; //Destination IP 2nd Octet
destIP += ".";
destIP += packet.get() & 0xFF; //Destination IP 3rd Octet
destIP += ".";
destIP += packet.get() & 0xFF; //Destination IP 4th Octet

//NOTE: RFC diagram showed a byte of zeroes here, but it doesn't appear to match the implementation
//int supposedZeroes = packet.get();
//Log.d(TAG, "Supposed Zeroes: " + supposedZeroes);

int sourcePortUdp = packet.getChar();
int destPortUdp = packet.getChar();
packet.getChar(); //UDP Data Length
packet.getChar(); //UDP Checksum
//NOTE: DNS HEADERS INSIDE UDP DATA - https://routley.io/tech/2017/12/28/hand-writing-dns-messages.html
packet.getChar(); //DNS ID
packet.get(); //OPTIONS: QR + OPCODE + AA + TC + RD
packet.get(); //OPTIONS: Z + RCODE
packet.getChar(); //DNS QDCOUNT //number of entities/questions
packet.getChar(); //DNS ANCOUNT //num answers
packet.getChar(); //DNS NSCOUNT //num auth records
packet.getChar(); //DNS ARCOUNT //num additional records
//NOTE: QNAME is url encoded, in several separated sections, each preceded by an int saying the number of bytes
//NOTE: The QNAME section is terminated with a zero byte (00).
int qnameSectionByteCount = packet.get();
byte[] qnameBytes = new byte[0];
byte[] qnameSectionBytes;
int oldLength;
while (qnameSectionByteCount > 0 && qnameSectionByteCount <= packet.remaining()) {
    qnameSectionBytes = new byte[qnameSectionByteCount];
    packet.get(qnameSectionBytes);
    //insert the bytes from the new section
    oldLength = qnameBytes.length;
    qnameBytes = Arrays.copyOf(qnameBytes, oldLength + qnameSectionBytes.length);
    System.arraycopy(qnameSectionBytes, 0, qnameBytes, oldLength, qnameSectionBytes.length);
    //get the byte that determines if there is another loop iteration
    qnameSectionByteCount = packet.get();
    //add a connecting dot if there will be another loop iteration
    if (qnameSectionByteCount > 0) {
        //add a dot
        byte[] dot = ".".getBytes();
        oldLength = qnameBytes.length;
        qnameBytes = Arrays.copyOf(qnameBytes, oldLength + dot.length);
        System.arraycopy(dot, 0, qnameBytes, oldLength, dot.length);
    }
}
packet.getChar(); //QCLASS
packet.getChar(); //QCLASS

String destHostName;
try {
    InetAddress addr = InetAddress.getByName(destIP);
    destHostName = addr.getHostName();
} catch (UnknownHostException e) {
    destHostName = "Unresolved";
}

int orphanDataLength = packet.remaining();
String dataStr = null;
if (orphanDataLength > 0) {
    byte[] data = new byte[orphanDataLength];
    packet.get(data, packet.arrayOffset(), orphanDataLength);
    dataStr = new String(data, Charset.forName("UTF-8"));
}

Log.v(TAG, "---\nHeaders:\nIP Version=" + ipVersion + "\nHeader-Length=" + headerLength
        + "\nTotal-Length=" + totalLength + "\nDestination=" + destIP + " / "
        + destHostName + "\nSource-IP=" + sourceIP + "\nProtocol=" + protocol
        + "\nSource-Port=" + sourcePortUdp + "\nDestPortUdp=" + destPortUdp + "\nQname="
        + new String(qnameBytes, Charset.forName("UTF-8")) + "\nRemaining-Data: " + dataStr);