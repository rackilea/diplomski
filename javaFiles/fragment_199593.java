List<Person> persons = personRepository.findAll();

        Person p = persons.get(0);
        p.setName("Ravi");
        personRepository.save(p);

        JqlQuery query = QueryBuilder.byInstanceId(persons.get(0).getId(), Person.class).build();
        List<CdoSnapshot> shadows = javers.findSnapshots(query);
        for (CdoSnapshot cdoSnapshot : shadows) {
            System.out.println(cdoSnapshot);
        }