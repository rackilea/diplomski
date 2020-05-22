public abstract class AbstractConnector {
    private final WebServiceTemplate webServiceTemplate;

    protected AbstractConnector(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }
}

@Service
public class MyConnector extends AbstractConnector {

    @Inject // or @Autowired
    public MyConnector(@Qualifier("myWebService") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }
}