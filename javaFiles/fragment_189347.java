public class UserDAO{

    private SqlSessionFactory sqlSessionFactory;

    public UserDAO() {

    }

    public UserDAO(SqlSessionFactory sqlSessionFactory ) {
        this.sqlSessionFactory = sqlSessionFactory;

    }
    public String getUserById(Integer userId) {
        SqlSession session = sqlSessionFactory.openSession();
        //int success = -100;
        String name=null;
        try {
            name = (String)session.selectOne("com.yourcomp.domain.User.getUserById",userId);
        }catch(Exception e){

        }finally {
            session.close();
        }
        return name;
    }
}