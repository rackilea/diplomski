public boolean equals(Object obj){
  if (obj == null) return false;
  if (obj == this) return true;
  if (obj instanceof Person){
    Person p = (Person) obj;
    return p.getId().equals(this.getId());
  }
  return false;
}