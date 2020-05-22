import com.google.gson.Gson;

public class TestTwo {
public static void main(String[] args) {
    User user = new User();
    user.setEmail("someone@gmailcom");
    user.setIs_active(true);
    user.setName("Cristian");
    user.setPassword("Cam");
    user.setPhone("1234123441");
    user.setUsername("cam.cri");

    Pojo pojo = new Pojo("cam.cri", "Cam", user);

    String result = (new Gson()).toJson(pojo);
    System.out.println(""+result);

    Pojo pojo2 = (new Gson()).fromJson(result, Pojo.class);

    System.out.println("Token: \t"+pojo2.getToken());
    System.out.println("email: \t"+pojo2.getUser().getEmail());
    System.out.println("is_active: \t"+pojo2.getUser().isIs_active());
    System.out.println("Name: \t"+pojo2.getUser().getName());
    System.out.println("Password: \t"+pojo2.getUser().getPassword());
    System.out.println("phone: \t"+pojo2.getUser().getPhone());
    System.out.println("Username: \t"+pojo2.getUser().getUsername());

}
}