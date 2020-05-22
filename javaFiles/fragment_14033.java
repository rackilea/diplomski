@Override  
  public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
    Employee e=new Employee();  
    e.setId(rs.getInt(1));  
    e.setName(rs.getString(2));  
    e.setSalary(rs.getInt(3));
    //e.someNonSetterMethod(customize(rs.getString(4)));
    return e;  
}