String empId = p.getEmpId();
String paramValue = "";
if (empId !=null && !empId.isEmpty())
    paramValue = " where b.empId=:empId";
String empName = p.getEmployeeName();
if (empName !=null && !empName.isEmpty()) {
    if (paramValue == "")
     paramValue =" where b.employeeName=:empName";
    else
     paramValue =paramValue + " and b.employeeName=:empName"; 
}       
System.out.println("=========paramvalues===="+paramValue);
Query query = session.createQuery("from RequestBean b"+paramValue);
//now set parameter values
if(empId !=null && !empId.isEmpty())
  query.setParameter("empId", empId);
if(empName !=null && !empName.isEmpty())
  query.setParameter("empName", empName);
recList = (List<RequestBean>) query.list();