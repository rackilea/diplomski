public class httpServer extends Thread  
{
    //Everything inside this method is executed in a new Thread
    @Override
    public void run()
    {
        super.run();

        System.out.println("THIS IS EXECUTED IN A THREAD");

        this.serverStuff();
    }

    private void serverStuff()
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
    }
}

public class Test 
{
    public static void main(String[] args) 
    {
        System.out.println("THIS IN NOT EXECUTED IN THREAD");

        //This call creates a new Thread. It calls the run()-Method
        new httpServer().start();
    }
}