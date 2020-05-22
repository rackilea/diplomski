@ManagedBean
@SessionScoped
public class InfoBean {

    private String mailNickname;

    public String getMailNickname() {
        return mailNickname;
    }

    public void setMailNickname(final String mailNickname) {
        this.mailNickname = mailNickname;
     }    

     // other fields, methods...
}