@Component
public class ApiServlet extends TServlet {
    private ApiMultiplexingProcessor processor;

    @Autowired
    public ApiServlet(ApiMultiplexingProcessor p) {
        super(p, new TBinaryProtocol.Factory());
        processor = p;
    }
}