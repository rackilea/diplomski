static List<Function<Person,?>> EQ_PROPS=Arrays.asList(
    Person::getName, Person::getSurname, Person::getAge);

@Override
public boolean equals(Object obj) {
    if(obj==this) return true;
    if(!(obj instanceof Person)) return false;
    Person p=(Person)obj;
    return EQ_PROPS.stream().allMatch(f->Objects.equals(f.apply(this), f.apply(p)));
}
@Override
public int hashCode() {
    return Objects.hash(EQ_PROPS.stream().map(f->f.apply(this)).toArray());
}