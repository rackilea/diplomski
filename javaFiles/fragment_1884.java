import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("Phone")
@Expose
private String phone;
@SerializedName("Name")
@Expose
private String name;

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

}