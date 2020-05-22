@Service
public class Searcher extends Thread implements ISearcher {

    @Autowired
    protected ISessionProvider sessionProvider;

    public Searcher() {
        //nothing should be here...
    }

    @PostConstruct
    public void init() {
        sessionProvider.doSomeStuff();
    }
}