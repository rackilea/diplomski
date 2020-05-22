@Service
public class EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Emp emp) {
        String sql = "insert into Employers values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getSalary()+"','"+emp.getDesignation()+"')";
        return jdbcTemplate.update(sql);
    }

    public int update(Emp emp) {
        String sql = "update Employers set name='"+emp.getName()+"',salary='"+emp.getSalary()+"',designation='"+emp.getDesignation()+"' where id='"+emp.getId()+"'";
        return jdbcTemplate.update(sql);
    }

    public int delete(Emp emp) {
        String sql = "delete from Employers where id='"+emp.getId()+"'";
        return jdbcTemplate.update(sql);
    }

    public Emp getById(int id) {
        String sql = "select * form Employers where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Emp>(Emp.class));
    }

    public List<Emp> getEmployees(){
        return jdbcTemplate.query("select * from Employers", new RowMapper<Emp>() {
            public Emp mapRow(ResultSet rs, int row) throws SQLException{
                Emp emp = new Emp();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setSalary(rs.getFloat(3));
                emp.setDesignation(rs.getString(4));
                return emp;
            }
        });
    }
}