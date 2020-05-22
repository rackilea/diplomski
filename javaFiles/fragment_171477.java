List<Person> persons;
List<Person> resultList = new ArrayList<>();
for(Person person: persons){
    if(istPalindrom((person.getFirstName().toCharArray())))
        resultList.add(person)
}
return resultList