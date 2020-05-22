public class AbstractView extends View {

    private String userName;
    private boolean isMobile;

    protected AbstractView(String templateName) {
        super(templateName);
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public boolean isMobile() { return isMobile; }

    public void setIsMobile(boolean mobile) { isMobile = mobile; }
}

public class PersonView extends AbstractView {

    private final Person person;

    public PersonView(Person person) {
        super("person.ftl");
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }
}