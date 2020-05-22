Criteria personCriteria = session.createCriteria(Person.class,"p");
personCriteria.createAlias("p.Country", "c");    
Criterion gender = Restrictions.eq("gender", "M");
Criterion country = Restrictions.eq("c.countryName", "India");
personCriteria.add(gender);
personCriteria.add(country);
List<Person> personList = personCriteria.list();