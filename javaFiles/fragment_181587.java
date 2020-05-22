String id = new String(readBuffer);

String query = "INSERT into asset(ID,TIMESTAMP) VALUES(?,?)";
PreparedStatement pstm = con.prepareStatement(query);
pstm.setString(1, id);
pstm.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
pstm.executeUpdate();