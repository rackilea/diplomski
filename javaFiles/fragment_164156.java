Dossier dossier = new Dossier("some info");
dossier.setId(1000L);
Person person = new Person("Peter", dossier);
dossier.setPerson(person);
em.persist(person);
em.persist(dossier);