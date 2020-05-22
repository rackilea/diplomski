public class Person implements Serializable {
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Person() {

    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private String name;
    private int age;
}