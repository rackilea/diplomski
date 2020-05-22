class Person {
    int ID;
    String fName;
    String lName;
    String city;
    int age;

    public Person(int ID, String fName, String lName, String city, int age) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return ID + ";" + fName + ";" + lName + ";" + city ";" + age;
    }
}