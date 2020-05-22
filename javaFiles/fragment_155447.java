import java.net.InetAddress;
import java.net.UnknownHostException;

String hostname = "Unknown";

try
{
    InetAddress addr;
    addr = InetAddress.getLocalHost();
    hostname = addr.getHostName();
}
catch (UnknownHostException ex)
{
    System.out.println("Hostname can not be resolved");
}