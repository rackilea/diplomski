ArrayList<Object> nonMatchedPersons = new ArrayList<Object>();
for (Person person : personList) 
    if (!employees.contains(person))
        nonMatchedPersons.add(person);
for (PersonNpi personNpi : npiList) 
    if (!employees.contains(personNpi))
        nonMatchedPersons.add(personNpi);