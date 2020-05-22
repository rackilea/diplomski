public List<Employee> fetchDistinctEmployee() {

        List<Employee> empList = new ArrayList<Employee>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select NAME, ID, DEP_CODE FROM Emp_Table sort by ID");

        Employee em = null ;
        while (rs.next()) {
            if(em == null || em.getID() != rs.getInt("ID")) {
                em = new Employee();
                em.setDEPCODE(new ArrayList<String>());
                empList.add(em);
            }
            em.setNAME(rs.getString("NAME"));
            em.setID(rs.getInt("ID"));
            em.getDEPCODE().add(rs.getString("DEP_CODE"));
        }
    return empList;
}