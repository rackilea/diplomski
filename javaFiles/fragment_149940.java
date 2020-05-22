private EntityManager em;
private EntityManagerFactory emf;

public void myFunction() {
  HashMap<String, String> properties = new HashMap<String, String>();
  properties.put("ConnectionDriverName", "org.postgresql.Driver");  //as for Postgres
  emf = Persistence.createEntityManagerFactory("ScheduleUnit", properties);
  em = emf.createEntityManager();
}