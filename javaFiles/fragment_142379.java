public class User {
    protected String name;
    protected String email;
    protected int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name + ": [ " + email + ", " + age + " ]";
    }
}