import java.net.*;
public class HostName
{
  public static void main(String args[])
  {
    InetAddress inetAddress =InetAddress.getByName("127.64.84.2");//get the host Inet using ip
    System.out.println ("Host Name: "+ inetAddress.getHostName());//display the host
  }
}