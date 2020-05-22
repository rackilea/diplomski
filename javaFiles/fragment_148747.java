// set some values for the record
String seat = "";
String sep = "";
int price = 0;
String foroom = "";
int printer = 0;

String sql = "INSERT INTO ticket (start_time, end_time, seat, sep, price, foroom, printer) VALUES (?, ?, ?, ?, ?, ?, ?)";
PreparedStatement prepared = connection.prepareStatement(sql);
prepared.setString(1, "2016-07-17 19:00:00");
prepared.setString(2, "2016-07-17 20:00:00");
prepared.setString(3, seat);
prepared.setString(4, sep);
prepared.setInt(5, price);
prepared.setString(6, foroom);
prepared.setInt(7, printer);
prepared.executeUpdate();