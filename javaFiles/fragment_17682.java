@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, isolation = Isolation.READ_COMMITTED)
public Client getOrCreate(String name) {
    DetachedCriteria query =
        DetachedCriteria.forClass(Client.class).add(Restrictions.eq("name", name));

    Client client = entityDao.findSingle(Client.class, query);

    if (client == null) {
        client = new Client();
        client.setName(name);
        entityDao.save(client);
    }
    return client;
}