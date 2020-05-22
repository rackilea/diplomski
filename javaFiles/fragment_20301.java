@Component
public class FtpServer {

    @Value("${ftp.port}")
    private int port;

    @PostConstruct
    public void init() {
        System.out.println(this.port);
    }

}