while (rs.next()) {
    id[i]=rs.getInt("id");
    name[i]=rs.getString("sname");
    contact[i]=rs.getInt("contact");
    System.out.println(""+id[i]+name[i]+contact[i]);
}