String sql_query = "SELECT username, firstname, lastname, 
    emailid, profession, mobileno, to_char(birthdate, 'MM/DD/YYYY') AS
    birthdate, password FROM EmployeeInfo WHERE username = ?";

Query query = session.createQuery(sql_query);
query.setString(0, username);
List<Employee> employees = (List<Employee>)query.list();