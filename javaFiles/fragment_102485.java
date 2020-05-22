if (protocol == 1) {
    parsedString = ICMP_packet_parser(b, index);
} else if (protocol == 6) {
    parsedString = TCP_packet_parser(b, index);
} else if (protocol == 11) {
    parsedString = UDP_packet_parser(b, index);
}