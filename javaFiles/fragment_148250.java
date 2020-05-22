@ResultPath(value="/pages")
@Namespace("/User")
public class WelcomeUserAction extends ActionSupport {

    @Action(value="/welcome", results={@Result(name="success", location="welcome_user.jsp")})
    public String execute(){
        return SUCCESS;
    }
}