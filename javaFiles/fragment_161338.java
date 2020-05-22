public class User {

    private final String id;
    private String personId;

    public User(String id, String personId) {
        this.id = id;
        this.personId = personId;
    }

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}