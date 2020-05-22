public void add(Human human) {
      entityManager.getTransaction().begin();
      entityManager.persist(human);
      entityManager.getTransaction().commit();
   }

public void edit(Human human) {
      entityManager.getTransaction().begin();
      entityManager.merge(human);
      entityManager.getTransaction().commit();
   }