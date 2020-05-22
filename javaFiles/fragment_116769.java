private void useObserver(ObserveableRepository repository) {
    PersonManager personManager = new PersonManager();
    personManager.addPerson(new Person("Hans", personManager));
    personManager.addPerson(new Person("Peter", personManager));
    personManager.addPerson(new Person("Max", personManager));
    log.info("List.size() : " + personManager.getPersonList().size());
    repository.save(personManager);
}