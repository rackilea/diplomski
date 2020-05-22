public List<Person> showByProductName(Product product) {

    List<Person> localList = new ArrayList<Person>();

    for (Person person: persons) {   // persons is the original List.
        if (person.getProduct() == product) {
            localList.add(person);
        }
    }

    return localList;
}