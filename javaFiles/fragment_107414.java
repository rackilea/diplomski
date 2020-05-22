public class StudentRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Customer();
        student.setId(rs.getInt("s_id"));
        student.setName(rs.getString("s_name"));
    //and so on
        return student;
    }

}

 return (Student) jdbcTemplate.queryForObject(selectSQL, new Object[]{id},
            new StudentRowMapper(Student.class));