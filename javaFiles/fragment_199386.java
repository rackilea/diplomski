public class Server
{
    public static void main(String ... args) throws IOException // It is better to catch it here...otherwise your app will be terminated.
    {
        // as usual...

        Game game = new Game( ... ); // create your game here.

        while(true) // consider to use a flag or other logic for stopping.
            new ServerClass(game, socketS.accept()).Start();

        // as usual...
}