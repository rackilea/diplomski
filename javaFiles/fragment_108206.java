public class MyUserDetailsService implements UserDetailsService{

    private EntityManager entityManager;
    @PersistenceContext
    public void setEntityManager(EntityManager newEm){
        this.entityManager = newEm;
    }

    public UserDetails loadUserByUsername(String username){

        // assuming that you have a User class that implements UserDetails
        return entityManager.createQuery("from User where username = :username", User.class)
                            .setParameter("username", username)
                            .getSingleResult();

    }
}