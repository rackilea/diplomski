public class User {

    private final String id;
    private final String personId;

    public User(String id, String personId) {
        this.id = id;
        this.personId = personId;
    }

    public User(String personId) {
        this.personId = personId;
        this.id = UUID.randomUUID().toString();
    }

    public String getPersonId() {
        return personId;
    }

}