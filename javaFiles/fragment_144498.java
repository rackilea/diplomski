ResultSet rs = statement.executeQuery("select info.id, info.job, info.salary, "
    + "person.id as personId, person.name as personName "
    + "from Person person join workInfo info "
    + "on person.id=info.id");
while(rs.next()){ 
    System.out.println("id: " + rs.getInt("personId"));
    System.out.println("name: " + rs.getString("personName"));