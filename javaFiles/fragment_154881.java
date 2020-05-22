public void adopt(Person person) {
    if (!person.adopted && !person.name.equals(this.name)) {
        person.parent = name;
        children.add(person.name);
        person.adopted = true;
    }
}