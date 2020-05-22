@Remote
public interface RemoteBeanRemote {
    // Implementation omitted
}

@Stateless(name = "RemoteBean")
public class RemoteBean implements RemoteBeanRemote {

    @EJB(beanName = "LocalBean")
    private LocalBeanLocal localBean;

    // Implementation omitted
}