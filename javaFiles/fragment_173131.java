public class PersonDirectory {
    private ArrayList<Person> persons;
    private DirectoryAdmin admin;
    public PersonDirectory() {
        persons = new ArrayList<Person>();
    }
    public PersonDirectory(DirectoryAdmin initialAdmin) {
        admin = initialAdmin;
    }
}