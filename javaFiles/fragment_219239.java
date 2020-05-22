public class DockerPop3AutocryptKeyProvidingAndReceivingTest {
    @Test
    public void test() throws InterruptedException {
        GenericContainer container = new GenericContainer<>("immerfroehlich/emailfilter:latest")
                .waitingFor(Wait.forLogMessage("Awaiting Connection.*", 1))
                .withExposedPorts(24999);

        container.start();

        String host = container.getContainerIpAddress();
        String port = container.getMappedPort(24999).toString();

        //The following is simplified, but copied from the working jar used in the Docker Client image/container
        MyPOP3Client client = new MyPOP3Client(host, port);
        client.connect();

        container.stop();
    }
}