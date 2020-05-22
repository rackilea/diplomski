String query = "insert into TB01(SERIAL,BLADETYPE,STARTT1) values (?, ?, ?)";
PreparedStatement pstmt = conn.prepareStatement(query);
pstmt.setString(1, bladeSerial);
pstmt.setString(2, bladeType);
pstmt.setString(3, String.valueOf(startTime1));
pstmt.executeUpdate();