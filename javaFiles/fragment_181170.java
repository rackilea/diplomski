public int averageAgeInt(List<Person> persons) {
    return (int) averageAgeDouble(persons);
}

public double averageAgeDouble(List<Person> personList) {
    return personList.stream().collect(Collectors.averagingInt(person -> person.getAge()));
}