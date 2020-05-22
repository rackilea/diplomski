public class WriteTest extends HttpServlet
{
    @Resource
    UserTransaction tx; // a UserTransaction reference is injected like a any other resource. It can also be looked up from JNDI.

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        ...
        tx.begin(); // Start a new JTA BMT
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        ...
        User user = new User("Hans", "Maulwurf", "hans.maulwurf@test.de");
        Adress adress = new Adress("Deppenstraße 3","Deppingen");
        //user.setAddress(adress);

        em.persist(user);
        em.close();
        ...
        tx.commit(); // Commit the JTA BMT
    }

}