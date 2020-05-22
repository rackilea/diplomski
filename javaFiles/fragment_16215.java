import com.google.gson.annotations.SerializedName;
public class UserObject{
@SerializedName("name")
public String name;

@SerializedName("email")
public String email;

@SerializedName("phone")
public PhoneObject phone;

public UserObject(){
phone=new Phone();
}

}