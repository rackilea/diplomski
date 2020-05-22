@Override
public int hashCode(){
    return Objects.hashCode(name, DoB);
}

@Override
public boolean equals(Object o) {
    if ( this == o ) {
        return true;
    }
    if ( o == null || o.getClass() != Person.class ) {
        return false;
    }
    final Person that = (Person) o;
    return Objects.equal(name, that.name) && Objects.equal(DoB, that.DoB);
}