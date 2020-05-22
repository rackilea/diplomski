public class InetSockerAddressWithEphemeralPortMain {

    public static void main(String[] args) throws InterruptedException, IOException {
        InetSocketAddress randomSocketAddressFirst = new InetSocketAddress(0);

        try (ServerSocket ssOne = new ServerSocket()) {
            System.out.println("randomSocketAddress port before any binding : " + randomSocketAddressFirst.getPort());
            ssOne.bind(randomSocketAddressFirst);
            System.out.println("local port after first binding :" + ssOne.getLocalPort());
        }

        try (ServerSocket ssTwo = new ServerSocket()) {
            ssTwo.bind(randomSocketAddressFirst);
            System.out.println("local port after second binding :" + ssTwo.getLocalPort());
            System.out.println("randomSocketAddress port after all bindings : " + randomSocketAddressFirst.getPort());
        }

    }
}