@Override
public boolean equals(Object obj) {
    if(obj==this) return true;
    if(!(obj instanceof Person)) return false;
    Person p=(Person)obj;
    return Stream.<Function<Person,?>>of(
          Person::getName, Person::getSurname, Person::getAge)
      .allMatch(f->Objects.equals(f.apply(this), f.apply(p)));
}