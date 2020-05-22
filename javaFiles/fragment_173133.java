public class PersonDirectory {
    private ArrayList<Person> persons = new ArrayList<Person>();
    private DirectoryAdmin admin;
    public PersonDirectory() {
    }
    public PersonDirectory(DirectoryAdmin initialAdmin) {
        // don't have to worry about forgetting to call this();
        admin = initialAdmin;
    }
}