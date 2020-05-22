Person person = mock(Person.class);
List<Person> personList = new ArrayList<>();
personList.add(person);

MyDAO dao = mock(MyDAO.class);
when(dao.findByName(name)).thenReturn(personList);