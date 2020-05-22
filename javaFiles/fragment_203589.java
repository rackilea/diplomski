while(rs.next()) {
   Vector vect = new Vector();
   vect.addElement(rs.getInt("ID"));
   vect.addElement(rs.getString("Name"));
   vect.addElement(rs.getFloat("Price"));
   vect.addElement(rs.getDouble("Quantity"));
   vect.addElement(rs.getDate("datetime"));
   vect.addElement(rs.getString("person"));
   vect_container.add(vect);
}