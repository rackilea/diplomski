Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM mytable WHERE columnfoo = 500");
while (rs.next()) {
    System.out.print("Column 1 returned ");
    OffsetDateTime localDate = rs.getObject(1, OffsetDateTime.class);
    System.out.println(localDate);
}
rs.close();
st.close();