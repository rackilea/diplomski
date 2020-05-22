public enum Dao {
INSTANCE;
public List<EventsDetail> getevents(String userId) {
    EntityManager em = EMFService.get().createEntityManager();
    Query q = em.createQuery("select t from EventsDetail t where t.MemberId = " + userId);
    q.setParameter("userId", userId);
    @SuppressWarnings("unchecked")
    List<EventsDetail> events = q.getResultList();
    return events;
  }
}