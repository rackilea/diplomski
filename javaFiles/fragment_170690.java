public class User {
     public enum UserType {
        ADMIN, EDITOR, USER;
     }

     public String id;
     public UserType userPermissions;
     public String actualName;

     public User(String username, UserType userType, String name) {
         id = username;
         userPermissions = userType;
         actualName= name;
     }

    public String getUsername() {
        return id;
    }

    public UserType getUserType() {
        return userPermissions;
    }       

    public String getName() {
        return actualName;
    }

    public void setUserType(UserType input) {
        userPermissions = input;
    }
}