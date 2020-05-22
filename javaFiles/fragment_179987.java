public class ExamplePrincipal implements Principal {
    private String name;
    private List<String> roles;

    public ExamplePrincipal(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }
    public String getName() {
        return this.name;
    }
    public List<String> getRoles() {
        return this.roles;
    }
}