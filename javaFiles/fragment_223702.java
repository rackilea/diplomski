@Test
public void testClient() {
    Network network = new Network(Config.HOSTNAME, Config.PORT)
    new Thread(network).start();

    int random = new Random().nextInt(1000);
    network.send(random + "");
    network.close();
}