public class MyRMIServerSocketFactory implements RMIServerSocketFactory
{
    private InetAddress address;

    public MyRMIServerSocketFactory(InetAddress address)
    {
        this.address = address;
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException
    {
        return new ServerSocket(port, 0, address);
    }

    @Override
    public boolean equals(Object that)
    {
        return that != null && this.getClass() == that.getClass() && this.address.equals((MyServerSocketFactory)that).address);
    }
}