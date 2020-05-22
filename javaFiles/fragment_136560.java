public class Child {
    private String name;
    private int age;
    private Gender gender;

    public void eat(){}

    public void sleep(){}

    public void cry(){}

    public Child (String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void main(String[] args) {
        Child childOne = new Child("tom", 3, Gender.MALE);
        System.out.println(childOne);    
    }
}