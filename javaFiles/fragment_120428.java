public class Person {

private String name;

private String lastName;

private String age;

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    if (name != null ? !name.equals(person.name) : person.name != null) return false;
    if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
    return age != null ? age.equals(person.age) : person.age == null;
}

@Override
public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (age != null ? age.hashCode() : 0);
    return result;
}
}