public class Client implements IClient
{
    public void haha()
    {
         // Prints a value to the server.
         getConnection().writeline("hi");
    }

    public BufferedWriter getConnection()
    {
         // Here you request a connection from the server.
         String ip = "10.20.50.60"; // Example.

         // Get the connection via your own classes.
         BufferedWriter out = new BufferedWriter(getOutputStream(ip));

         return out;

    }

    private OutputStream getOutputStream(String ip)
    {
        // Logic to get the socket stream pointing to the server.
    }
}