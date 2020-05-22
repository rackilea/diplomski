@Repository
public class YourRepositoryJdbc implements YourRepository{

   @Autowired
   private NamedParameterJdbcTemplate jdbcTmpl;

   public List<Object> getObjects(){

      StringBuilder sql = new StringBuilder();
      sql.append("SELECT ob.id, ob.name ");
      sql.append("FROM objects ob ");
      sql.append("WHERE ob.del_flag = 0 ");

      List<Object> allObjects = jdbcTmpl.query(sql.toString(), new ResultSetExtractor<List<Object>>(){ 
         @Override
         public List<Object> extractData(ResultSet rs) throws SQLException, DataAccessException {

            while(rs.next()) {
               Object local = new Object();
               local.setId(rs.getIng("id"));
               local.setName(rs.getString("name"));
               allObjects.add(local);
            }
            return allObjects;

         }
    }
}