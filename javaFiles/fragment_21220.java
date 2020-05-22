class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    String myName() { return "Your name is: " + name; }
    String myAge() { return "Your age is: " + age; }
    String myGender() { return "You are: " + gender; }
}