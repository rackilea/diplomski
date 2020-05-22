import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Hashtable;

public class Main
{

    public static void main(String[] args) throws IOException {

        Hashtable<Integer, OutputStream> ht = new Hashtable<Integer, OutputStream>();

        for(int i = 0; i < 5; i++)
            ht.put( i, new DataOutputStream(new ByteArrayOutputStream()) );

        Socket sock = new Socket("google.com", 80);
        ht.put( ht.size(), sock.getOutputStream() );

        for(OutputStream dos : ht.values())
            System.out.println(dos);

        System.out.println(sock.getOutputStream());
    }
}