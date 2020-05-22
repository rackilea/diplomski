@Override
public int compareTo(Person o) {
    int ret = age - o.getAge();
    if (ref == 0) {
        return name.compareTo(o.getName());
    }
    return ret;
}

@Override
public boolean equals(Object o) {
    if (o instanceof Person) {
        Person p = (Person) o;
        return p.getAge() == age && p.getName().equals(name);
    }
    return false;
}