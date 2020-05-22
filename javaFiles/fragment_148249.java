@ResultPath(value="/pages")
@Namespace("/User")
@Action(value="/welcome", results={@Result(name="success", location="welcome_user.jsp")})
public class WelcomeUserAction extends ActionSupport {

    public String execute(){
        return SUCCESS;
    }
}