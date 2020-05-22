public class BootstrapExample
{
    public static void main(String[] args)
    {
        // On a Bootstrap, calling the 'channel' method
        // will return a Bootstrap 
        Bootstrap bootstrap = new Bootstrap();
        Bootstrap resultBootstrap = 
            bootstrap.channel(null);

        // On a ServerBootstrap, calling the 'channel' method
        // will return a ServerBootstrap 
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ServerBootstrap resultSeverBootstrap = 
            serverBootstrap.channel(null);
    }
}

abstract class AbstractBootstrap<
    B extends AbstractBootstrap<B, C>, 
    C extends Channel> implements Cloneable
{
    public B channel(Class<? extends C> channelClass)
    {
        return null;
    }
}
class Bootstrap extends AbstractBootstrap<Bootstrap,Channel> {}
class ServerBootstrap 
    extends AbstractBootstrap<ServerBootstrap,ServerChannel> {}
class Channel {}
class ServerChannel extends Channel {}