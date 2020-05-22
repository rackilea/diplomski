@Autowired
private EntityManager entityManager;

public SystemNode getSystemWithHistoryFrom(UUID uuid) {
    Session session = entityManager.unwrap(Session.class);

    Filter filter = session.enableFilter("dateFilter");
    filter.setParameter("fromDate", new DateTime().minusHours(4).toDate());

    SystemNode systemNode = systemRepository.findByUuid(uuid)
            .orElseThrow(() -> new EntityNotFoundException("Could not find system with id " + uuid));

    session.disableFilter("dateFilter");

    return systemNode;
}