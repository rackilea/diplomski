Person richest = new Person(/*Any default initializers here*/);

// This will set 'richest' to the richest person
for (Person p : personRegistry) {
    if (p.getValue() > richest.getValue())
        richest = p;
}

System.out.println("Richest person is: " + richest.getName());
System.out.println("Total value: " + richest.getTotalValue());

System.out.println(richest.getName() + " owns: ");
for (Item i : richest.getItems()) {
    System.out.println(i.getName() + " " + i.getValue());
}