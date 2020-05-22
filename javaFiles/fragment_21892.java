@Repository
    //you are calling this in ur code as PersonDAOImpl..change it to UserDAOImpl
    public class UserDAOImpl implements UserDAO {

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
        }

        @Override
        public int updateUser(String userId, String userName) {
            Session session = this.sessionFactory.getCurrentSession();
         Query query = session.createQuery("update User set userName =:userName where userId = :userName ");
         query.setString("userName", userName);  
         query.setString(userName, userName);  
         int result = query.executeUpdate();
         return result;
        }
    }