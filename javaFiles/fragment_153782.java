@Override
public boolean equals(Object o) {
    if (o instanceof Person) {
        Person p = (Person) o;
        return name.equals(p.name) && age == p.age;
    }
    return false;
}

@Override
public int hashCode() {
    return Arrays.asList(name, age).hashCode();
}