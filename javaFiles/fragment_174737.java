public class User {

    private String name;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}

User user = (new User()).setName('Me').setPhone('1234');