@Autowired
private SessionFactory sf;

@Transactional
public Long noOfEmployees() {
    final String query = "select count(*) from employee where job=:job";
    Query q = sf.getCurrentSession().createSQLQuery(query);
    if ("user1".equals(u)) {
        q.setParameter("job", "System Analyst");
    } else if ("user2".equals(u) ) {
        q.setParameter("job", "DBA");
    }
    return (Long) query.uniqueResult();
}