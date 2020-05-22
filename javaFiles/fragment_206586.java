public class Worker {

    private final String firstName;
    private final int age;
    private final String job;

    public Worker(String firstName, int age, String job) {
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }
}