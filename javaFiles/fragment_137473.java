public class Message {
    private int code;
    private String message;
    //constructor...
    //getters and setters...
}

public class UserBL {

    public Message create(User user) {
        //do some fancy validations
        if (!verifyDuplicatedUser(user)) {
            return new Message(-1000, "Duplicated user");
        }
        //and the operations...
        saveUser(user);
        return new Message(0, "Register successfully!");
    }

}