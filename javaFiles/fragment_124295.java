import org.apache.openejb.api.LocalClient;

@LocalClient
public class ChatBeanTest extends TestCase {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "QuestionBean")
    private Queue questionQueue;

    @Resource(name = "AnswerQueue")
    private Queue answerQueue;

    @EJB
    private MyBean myBean;


    @Override
    protected void setUp() throws Exception {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        InitialContext initialContext = new InitialContext(p);

        initialContext.bind("inject", this); // here's the magic!
    }
}