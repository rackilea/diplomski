Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(
    "SELECT (citycode || '-' || hotelcode) AS cityhotel FROM cityHotelData"
);
while (rs.next()) {
    System.out.print("City-hotel code: ");
    System.out.println(rs.getString(1));
}
rs.close();
st.close();