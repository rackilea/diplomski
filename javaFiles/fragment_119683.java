@WebService
@Transactional
public class UserManagementServiceImpl {

    private WebServiceContext context;

    @Resource
    public void setContext(WebServiceContext context) {
        this.context = context;
    }
    ...
}