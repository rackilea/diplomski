public static void main(String[] args) {
    Person[] people = { new Person("Bob", 3.6), //
            new Person("Steve", 11.0), new Person("Thomas", 2.2) };
    System.out.println("Before Sorting");
    for (Person p : people) {
        System.out.println(p);
    }
    Arrays.sort(people);
    System.out.println("After Sorting");
    for (Person p : people) {
        System.out.println(p);
    }
}