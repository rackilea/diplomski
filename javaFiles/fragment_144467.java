private final SessionFactory sessionFactory;

    @Autowired
    public DAOClasname(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

// I am presuming you want user and passing user id.
    // Don't just throw Exception, use something meaningful
public User getUserById(long id){
        Session session = this.sessionFactory.getCurrentSession();
return (User)session.get(User.class,id);

}

// I am presuming you are passing user id and expect users profession
// Don't just throw Exception, use something meaningful
public List<Profession> getProfessionById(long id){
        Session session = this.sessionFactory.getCurrentSession();
   org.hibernate.Query query = session.createQuery("from Profession as P where p.usersProfession.userId=:id");
   query.setParameter("id",id);
return query.list();
}