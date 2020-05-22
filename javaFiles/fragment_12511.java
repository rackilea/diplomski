while (rs.next()){
   Technician empl = new Technician();
   empl.setEmpFName(rs.getString("EMP_LNAME"));          
   empl.setEmpLName(rs.getString("EMP_FNAME"));          
   empl.setEmpId(rs.getInt("EMP_ID"));          
   employees.add(empl);
}