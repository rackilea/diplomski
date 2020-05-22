@ManagedBean
@SessionScoped
public class MUserSessionBean {

    private MyUser currentUser;

    @PostConstruct
    public void init() {
        if (currentUser == null) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

            currentUser = (MyUser) context.getSessionMap().get("user");
        }
    }
...
}