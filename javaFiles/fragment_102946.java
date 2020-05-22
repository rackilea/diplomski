@ServerEndpoint("/endpoint")
public class BeanThree {
    @Inject
    ApplicationScopedBean bean;

    @OnOpen
    public String onOpen(Session s) { System.out.println(bean); }
    @OnMessage
    public String onMessage(String message) { System.out.println(bean); }
}
@ApplicationScoped
public class ApplicationScopedBean { ... }