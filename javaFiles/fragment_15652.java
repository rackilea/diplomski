List<Person> personList = new ArrayList<Person>();

for(int i = 0; i < nameList.size(); i ++) {
    String name = nameList.get(i);
    int age = ageList.get(i);
    String qual = qualList.get(i);
    personList.add(new Person(name, age, qual));
}