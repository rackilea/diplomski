import com.google.gson.annotations.SerializedName;


public class User {

@SerializedName("username")
private String username;

@SerializedName("name")
private String name;

@SerializedName("phone")
private String phone;

@SerializedName("email")
private String email;

@SerializedName("password")
private String password;

@SerializedName("is_Active")
private boolean is_active;

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public boolean isIs_active() {
    return is_active;
}

public void setIs_active(boolean is_active) {
    this.is_active = is_active;
}
}