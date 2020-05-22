ResultSet rs = statement.executeQuery("select info.id, info.job, info.salary, "
    + "person.id, person.name from Person person join workInfo info "
    + "on person.id=info.id");
while(rs.next()){ 
    System.out.println("id: " + rs.getInt(4));
    System.out.println("name: " + rs.getString(5));