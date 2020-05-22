EntityManager em = emf.createEntityManager();

boolean isJta = false;
try {
    EntityTransaction et = em.getTransaction();
} catch (IllegalStateException ise) {
    if (ise.getMessage().startsWith("A JTA EntityManager cannot use getTransaction")) {
        isJta = true;
    }
}