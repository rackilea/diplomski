struct sockaddr_in addressData;
memset(&addressData, 0, sizeof(addressData));
addressData.sin_len = sizeof(addressData);
addressData.sin_family = AF_INET;
addressData.sin_port = htons(broadcastPort);
addressData.sin_addr.s_addr = inet_addr(broadcastIP);
NSData *address = [NSData dataWithBytes:&addressData length:sizeof(addressData)];
if (kCFSocketSuccess != CFSocketSetAddress(advertiseSocket, (CFDataRef)address)) {
    [self stopBeforeStart];
    [self connectionFailed];
    return;
}

struct ip_mreq mreq;
mreq.imr_multiaddr.s_addr = inet_addr(broadcastIP);         
mreq.imr_interface.s_addr = INADDR_ANY;