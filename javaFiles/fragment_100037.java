private int age;
private Sex sex;

public boolean isFemaleAdult() {
    return sex == Sex.FEMALE && age >= 18
}