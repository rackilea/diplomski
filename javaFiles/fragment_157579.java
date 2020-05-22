@FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")    
public class UserForm {
     private String email;
     private String confirmEmail;
     ...
}