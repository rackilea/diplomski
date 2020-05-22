class Person {
    int age;
    Person(int age) {
        if(age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }
}