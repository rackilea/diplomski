import com.google.gson.annotations.SerializedName;

public class Pojo {

@SerializedName("token")
private String token;

@SerializedName("user")
private User user;

public Pojo(String username, String password,User user) {
    // TODO Auto-generated constructor stub
    user.setUsername(username);
    user.setPassword(password);
    this.token = "tokengfsgfds";
    this.user = user;
}

public String getToken() {
    return token;
}

public void setToken(String token) {
    this.token = token;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}
}