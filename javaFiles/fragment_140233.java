public class Student {
    private String name;
    public Student(String str) {
        name = str;
    }
    public void setName(String str) {
        name = str;
    }
    public String getName() {
        return name;
    }

    public static void main(String args[]) {
        Student s = new Student("amro");
        s.setName("unknown");
        System.out.println("Hello " + s.getName());
    }
}