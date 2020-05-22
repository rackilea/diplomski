EntityManager entityManager = Persistence.createEntityManagerFactory("catalogueLibraryPU").createEntityManager();
   Query query = entityManager.createNamedQuery("Photos.findAll");
   List<Photos> resultList = query.getResultList();
   for (Photos c : resultList) {
   jTextArea1.append(c.getTitle() + " (" + c.getLocation() + ")" + "\n");
  }