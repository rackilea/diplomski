@Override
public boolean equals(Object obj) {
    if(obj==this) return true;
    if(!(obj instanceof Person)) return false;
    Person p=(Person)obj;
    return this.age==p.age && Objects.equals(this.name, p.name)
      && Objects.equals(this.surname, p.surname);
}