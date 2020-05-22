public class Provider {

    @Qualifier("child1")
    @Autowired
    private ParentFeedAPI feedAPI;

}

public interface ParentFeedAPI {

}

@Component("child1")
public class Child1FeedAPI implements ParentFeedAPI{

}

@Component("child2")
public class Child2FeedAPI implements ParentFeedAPI{

}