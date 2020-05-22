public class UserDAOImpl implements UserDAO {
   private JdbcTemplate jdbcTemplate;
   //setter and getter for jdbcTemplate

   public List<Map<String, Object>> getUsers() {
       String query = "select * from user";
       return jdbcTemplate.queryForList(query, new HashMap<String, String>());
   }
}