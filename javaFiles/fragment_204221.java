public class EmployeeStatus {
    private int id;
    private String name;
    public EmployeeStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @JsonProperty("ID")
    public int getId() {
        return this.id;
    }
    @JsonProperty("Name")
    public String getName() {
        return this.name;
    }
}