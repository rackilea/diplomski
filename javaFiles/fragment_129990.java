public List<Person> getPersons() {
    if (this.persons == null) {
       this.persons =  new LinkedList<Person>();
    }
    return this.persons;
}