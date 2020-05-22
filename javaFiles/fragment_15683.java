int sumOfC = 0;
for (Person person : persons) {
    if (person.getCreditOrDebit().equals("C")){
        sum += person.getSalary();
    }
}
Person p = new Person(sumOfC, tax, "C");