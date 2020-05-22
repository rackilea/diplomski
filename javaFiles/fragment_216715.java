public class Picture {
    private String name;
    // other properties omitted for clarity
    public Picture() {
        this.name = "some default";
    }

    // use getters/setters to access and assign object data, which can include
    // user-input obtained at runtime
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}