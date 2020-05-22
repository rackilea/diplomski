private InputStream inputStream;

public ImputStream getInputStream(){
  return inputStream;
}

public String visualizzaimg() throws SQLException, IOException {
    Connessione();    // DB connection method
    PreparedStatement pstmt = con.prepareStatement("SELECT Immagine FROM Utenti WHERE Username = ?");
    pstmt.setString(1,username);
    ResultSet rs = pstmt.executeQuery();
    if(rs.next()){
      inputStream = rs.getBinaryStream(1);
    }
    return "success";
}