@Autowired
private HazelcastInstance hazelcastInstance;

// ...

// from org.springframework.session.hazelcast.HazelcastSessionRepository
final Collection<Session> sessions = (Collection) hazelcastInstance.getMap(HazelcastSessionRepository.DEFAULT_SESSION_MAP_NAME).values();
for(final Session session : sessions) {
  System.out.println(session.getId() + ": " + session.getAttribute("Session-Type"));
}