@Entity
public class Error {

    private String app;
    private String name;
    private String email;

    //getter setter

    @Override
    public String toString() {
        return app + "~" + name + "~" + email;
    }
}