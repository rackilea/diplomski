@ManagedBean
@RequestScoped
public class BaseBean {

    private Article article;

    @ManagedProperty(value="#{injectedBean}")
    private InjectedBean injectedBean;

}