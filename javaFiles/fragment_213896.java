public class DNSResolver implements Runnable {
    private String domain;
    private InetAddress inetAddr;

    public DNSResolver(String domain) {
        this.domain = domain;
    }

    public void run() {
        try {
            InetAddress addr = InetAddress.getByName(domain);
            // when IP address is found, make it accessible
            set(addr);
        } catch (UnknownHostException e) {
            // IP address has not been found, ignore
        }
    }

    public synchronized void set(InetAddress inetAddr) {
        this.inetAddr = inetAddr;
    }
    public synchronized InetAddress get() {
        return inetAddr;
    }
}