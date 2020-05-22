import org.apache.commons.net.time.TimeTCPClient;

public final class GetTime {

public static final void main(String[] args) {
    try {
        TimeTCPClient client = new TimeTCPClient();
        try {
            client.setDefaultTimeout(60000);
            client.connect("time.nist.gov");
            System.out.println(client.getDate());
        }
        catch (IOException e) {
           e.printStackTrace();
        }
        finally {
           client.disconnect();
        }
    }
}