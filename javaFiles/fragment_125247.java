private void persistAllToDB() {
    int counter = 0;
    for (Persistable persistable : batch.values())
        em.persist(persistable);
        counter++;
        if(counter % 20 == 0){
           em.flush();
           em.clear();
        }
    }
}