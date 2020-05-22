String ip = "192.168.1.97";

// cut the last octet from ip (if you want to keep the . at the end, add 1 to the second parameter
String firstThreeOctets = ip.substring(0, ip.lastIndexOf(".")); // 192.168.1

String lastOctet = ip.substring(ip.lastIndexOf(".") + 1); // 97