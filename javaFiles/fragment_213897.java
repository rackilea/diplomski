DNSResolver dnsRes = new DNSResolver(host);
Thread t = new Thread(dnsRes);
// start resolving address in another thread
t.start();
// wait for a second for result
t.join(1000);
InetAddress inetAddr = dnsRes.get();