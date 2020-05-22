List<Person>persons = new ArrayList<>();

 persons.add(new Person("MAR 2, 2001"));
 persons.add(new Person("JAN 7, 1972"));
 persons.add(new Person("JAN 2, 1976"));
 persons.add(new Person("MAR 4, 1985"));

 Collections.sort(persons);

 for(Person p : persons)
   System.out.println(p.formatter.format(p.birthDay));
                 //Person.formatter is SimpleDateFormat with format "MMM dd, yyyy" 
                 // in person class, i declared it as static