public class ConnectionPoolableObjectFactory
        extends BasePoolableObjectFactory<Channel> {

    private final Connection connection;

    private ConnectionPoolableObjectFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    @Override
    public Channel makeObject() throws Exception {
        return connection.createChannel();
    }

    @Override
    public boolean validateObject(Channel channel) {
        return channel.isOpen();
    }

    @Override
    public void destroyObject(Channel channel) throws Exception {
        channel.close();
    }

    @Override
    public void passivateObject(Channel channel) throws Exception {
        //System.out.println("sent back to queue");
    }
}