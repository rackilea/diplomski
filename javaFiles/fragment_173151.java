import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPFile;

public class BasicFTP {

    public static void main(String[] args) throws IOException {
        FTPClient client = new FTPClient();
        client.connect("c64.rulez.org");
        client.enterLocalPassiveMode();
        client.login("anonymous", "");
        FTPFile[] files = client.listFiles("/pub");
        for (FTPFile file : files) {
            System.out.println(file.getName());
        }
    }
}