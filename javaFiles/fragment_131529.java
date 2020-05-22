Person person = new Person();
        person.setId(100L);
        person.setName("SomeName");
        Child child = new Child();
        child.setId(60L);
        child.setPerson(person);
        person.setChild(child);
        personRepository.save(person);