@Service
public class FTPService {

@Value("${ftp.server}")
private String server;

public String getServer() {
    return server;
}
}