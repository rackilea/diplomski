@ManagedBean
@RequestScoped
public class MainController {

    @ManagedProperty("#{loginController}") // +getter+setter
    public LoginController loginController;

    @PostConstruct // Will be invoked directly after construction and managed property injection.
    public void checkUserSession() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        if (!loginController.getIsLoggedIn()) {
            ec.redirect(ec.getRequestContextPath() + "/views/login.html");
        }
    }

    public boolean isShowComponent() {
        return loginController.getIsLoggedIn();
    }

}