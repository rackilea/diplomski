String sql = "select e.* from employee e,  department d where d.department_name = ? and d.department_name=e.deparment.name"); )// ? will be replaced by a parameter obtained from a user

PreparedStatement stmt = con.prepareStatement(sql);

stmt.setString(1, deptName); //deptName is obtained from the user

ResultSet rs = stmt.executeQuery();
.....