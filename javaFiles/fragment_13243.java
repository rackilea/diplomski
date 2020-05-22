@Service
public class MyClient {
    @Autowired
    @Qualifier("port1")
    private WsPort port;
}