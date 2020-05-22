ArrayList<Person> richestPeople = new ArrayList<Person>();

Person richest = new Person(/*Any default initializers here*/);
for (Person p : personRegistry) {
    if (p.getValue() > richest.getValue())
        richest = p;
}

// now check to see if there are people with same value
for (Person p : personRegistry) {
    if (p.getValue() == richest.getValue())
        // add them to the list
        richestPeople.add(p);
}

// now we loop through the list of richest people and print them out
for (Person p : richestPeople) {
    System.out.println("Richest person is: " + p.getName());
    System.out.println("Total value: " + p.getTotalValue());

    System.out.println(p.getName() + " owns: ");
    for (Item i : p.getItems()) {
        System.out.println(i.getName() + " " + i.getValue());
    }
}