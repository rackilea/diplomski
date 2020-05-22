public class Student {
    private RestClient client;

    public Student(Client client) {
        this.client = new RestClient(client, "xyz");
    }

    public RestClient getClient() {
        return this.client;
    }

    public void addStudent() {}

    public static void main(String...args) {
        new Student(Client.create()).addStudent();

        // or a more verbose way
        Client jerseyClient = Client.create();
        Student student = new Student(jerseyClient);
        student.addStudent();
    }
}