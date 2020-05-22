public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer addPerson(Person p) {
        Session session = sessionFactory.getCurrentSession();
        Integer personID = (Integer) session.save(p);
        return personID;
    }

    public Person getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person retrievedPerson = (Person) session.get(Person.class, id);
        return retrievedPerson;
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonsList() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Person.class);
        return criteria.list();
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person personToDelete = getById(id);
        session.delete(personToDelete);
    }

    public void update(Person personToUpdate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(personToUpdate);
    }
}