Calendar cal = Calendar.getInstance();
cal.setTime(dateInstance);
cal.add(Calendar.DATE, -30);
Date dateBefore30Days = cal.getTime();    
 public Stream<Person> all(Person mysearch){ 
       return personRepository 
              .findAll(Example.of(mysearch)).stream().filter(person -> person.getExdate().compareTo(dateBefore30Days) > 0)
                .map(Person::fromPerson)                       
                .findAny()
                .orElse(""); }