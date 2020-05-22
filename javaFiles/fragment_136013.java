public class IsAddressDirectlyConnected {

    private static class Network {
        int network;
        int mask;

        Network(int n, int m) {
            network = n;
            mask = m;
        }
    };

    // list of networks on interfaces of machine this code is being run on
    List<Network> mDirectlyAttachedNetworks = new ArrayList<Network>();

    private int addrBytesToInt(byte[] addr) {
        int addri = 0;
        for (int i = 0; i < addr.length; ++i)
            addri = (addri << 8) | ((int)addr[i] & 0xFF);        
        return addri;
    }

    private void collectLocalAddresses() {
        try {
            Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();

            while (nifs.hasMoreElements()) {
                NetworkInterface nif = nifs.nextElement();
                if (nif.isUp()) {
                    List<InterfaceAddress> ias = nif.getInterfaceAddresses();
                    for (InterfaceAddress ia : ias) {
                        InetAddress ina = ia.getAddress();
                        if (ina instanceof Inet4Address) {
                            int addri = addrBytesToInt(ina.getAddress());
                            int mask = -1 << (32 - ia.getNetworkPrefixLength());
                            addri &= mask;
                            mDirectlyAttachedNetworks.add(new Network(addri, mask));
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            System.err.println("Socket i/o error: " + ex.getLocalizedMessage());
        }
    }

    public boolean isDirectlyAttachedAndReachable(InetAddress address) {
        int checkedAddr = addrBytesToInt(address.getAddress());
        try {
            if (!address.isReachable(1000))
                return false;
        } catch (IOException ex) {
            System.err.println("Failed to check reachability: " + ex.getLocalizedMessage());
            return false;
        }

        for (Network n : mDirectlyAttachedNetworks) {
            if ((checkedAddr & n.mask) == n.network)
                return true;
        }
        return false;
    }

    public IsAddressDirectlyConnected() {
        collectLocalAddresses();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IsAddressDirectlyConnected iadc = new IsAddressDirectlyConnected();

        if (args.length == 1) {
            try {
                boolean check = iadc.isDirectlyAttachedAndReachable(Inet4Address.getByName(args[0]));
                System.out.println("Given IP is " + (check ? "" : "not ") + "on directly attached network " + (check ? "and " : "or not ")  + "reachable from local host.");
            } catch (UnknownHostException ex) {
                System.err.println("Failed to parse address: " + ex.getLocalizedMessage());
            }
        } else System.out.println("Specify address to check.");
    }
}