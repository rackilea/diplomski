public static void main(String[] args) {
    Person jim = new Person("Jim", 40, "male");
    Person sally = new Person("Sally", 12, "female");

    report(jim);
    report(sally);
}

private static report(Person person) {
    System.out.println(person.myName());
    System.out.println(person.myAge());
    System.out.println(person.myGender());
}