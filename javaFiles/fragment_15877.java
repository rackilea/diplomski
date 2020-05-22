int ip = d.ipAddress;
while (ip & d.netmask) {
    // Valid ip
    ip++
}
ip = d.ipAddress - 1;
while (ip & d.netmask) {
    // Valid ip
    ip--
}