public class LoginBean{


private String username;
private String password;
private int divisionId;

/**
 * Creates a new instance of loginBean
 */

public LoginBean() {
}
public static void redirect(String strDes) throws IOException {
    ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
    ext.redirect(ext.getRequestContextPath() + strDes);
}
public void doLogin() {


    DbUser du = new DbUser();
    divisionId = du.ValidateUser(username, password);


    if(divisionId==0)
        addMessage("Invalied username or password", false);
    else{

        if(divisionId==1){ 
            LoginBean.redirect("superuser.xhtml?test="+divisionId+"faces-redirect=true");
            //superAdmin                         
       }
        else if(divisionId==2||divisionId==3){    
           LoginBean.redirect("engadmin_create_div.xhtml?test="+divisionId+"faces-redirect=true");
            //ENG/IT ADMIN    
        }
        else{
            LoginBean.redirect("viewonly_user.xhtml?test="+divisionId+"faces-redirect=true");
            //View only users
        }
    }       
}