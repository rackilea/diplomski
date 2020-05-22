public class MyCustomClass {
    @JsonProperty("users")
    public LinkedHashMap<String, User> users;

    @JsonProperty("jobs")
    public ArrayList<Job> jobs;
}