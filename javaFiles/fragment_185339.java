@Component
@Scope(proxyMode = ScopedProxyMode.INTERFACES, value = WebApplicationContext.SCOPE_REQUEST)
public class RequestScopedBean {
    public void method() {}
}
...
@Autowired
private RequestScopedBean bean;