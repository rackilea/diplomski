EmployeeDAO employeeDAO; // dependency to mock

// constructor with dependency
public Example(EmployeeDAO employeeDAO){
  this.employeeDAO = employeeDAO;
}

private Employee method1(String str) {
   ResultSet resultSet = employeeDAO.load(str);

    if(null != rs) {            
        while(rs.next()) { 
            ilCounter++;
            ObjVoBean voObj = new ObjVoBean();
            voObj.setLoc(rs.getString(1));
            voObj.setDept(rs.getString(2));
            voObj.setDeptDesc(rs.getString(3));
        }
        .................
    }
   }