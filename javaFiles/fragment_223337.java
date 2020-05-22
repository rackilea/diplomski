public class MyActionClass extends ActionSupport implements ModelDriven<UserDTO>{

private UserDTO user;

public UserDTO getUser() {
    return user;
}


public void setUser(UserDTO user) {
    this.user = user;
}

@Override
public String execute() throws Exception {

    return SUCCESS;
}

}