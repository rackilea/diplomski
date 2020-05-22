public void registerCustomEntityPersister(Configuration configuration) {
     final Iterator<PersistentClass> classesIterator = configuration.getClassMappings();
 while (classesIterator.hasNext()) {
    final PersistentClass persistentClass = classesIterator.next();
        if (checkIfIsOneTheClassesThatMatters(persistentClass)) {
          persistentClass.etEntityPersisterClass(CustomEntityPersister.class); 
        }
 }