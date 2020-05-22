public  ArrayList<Employee> search(String unit, String name) {
    ArrayList<Employee> temp= new ArrayList<>();
    String sql="SELECT * FROM employees WHERE unit like ? AND name=?";

    try (PreparedStatement pStmnt = conn.prepareStatement(sql)) {

        if("all units".equals(unit))
            pStmnt.setString(1, "%");
        else
            pStmnt.setString(1, unit);

        pStmnt.setString(2, name);
        ResultSet rs=pStmnt.executeQuery();
        while(rs.next())
        {
            temp.add(new Employee(rs.getString("name"), rs.getInt("active")==1);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    temp.sort(Comparator.comparing(Employee::getName));
    return temp;
}