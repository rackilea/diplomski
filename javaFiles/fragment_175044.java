Query q = pm.newQuery(Person.class);
q.setFilter("lastName == lastNameParam");
q.setOrdering("height desc");
q.declareParameters("String lastNameParam");
q.setParameter("lastNameParam", "Smith");
List<Person> results = (List<Person>) q.execute();