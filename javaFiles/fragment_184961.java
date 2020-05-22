public class Address  {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    String ip;

    Address(String ip) {
        this.ip = ip;
    }

    boolean isLinkLocal() throws UnknownHostException{
        return getInet6Address().isLinkLocalAddress();
    }

    @SuppressWarnings("static-access")
    Inet6Address getInet6Address() throws UnknownHostException {
        return (Inet6Address) Inet6Address.getByName(getIp());
    }

    String getIp() {
        return this.ip;
    }
}