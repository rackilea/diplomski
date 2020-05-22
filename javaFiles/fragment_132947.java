Connection conn = DriverManager.getConnection(connectionURL, user, password);
PreparedStatement pstmt = 
    conn.prepareStatement("insert into your_html_container (content) values (?)");
pstmt.setString(1, fullHtml); // this is your html string from step #1
pstmt.executeUpdate();
pstmt.close();
conn.close();