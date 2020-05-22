public class UserDetail {

@SerializedName("ID")
@Expose
private Integer iD;
@SerializedName("user_email")
@Expose
private String userEmail;

public Integer getID() {
return iD;
}

public void setID(Integer iD) {
this.iD = iD;
}

public String getUserEmail() {
return userEmail;
}

public void setUserEmail(String userEmail) {
this.userEmail = userEmail;
}

}