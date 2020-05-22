public LinkedList<Athlet> alleAbrufen () throws SQLException {
    LinkedList<Athlet> alleAthleten = new LinkedList<Athlet>();
    String abrufenAthleten = "SELECT * FROM Athlet ORDER BY athlet_id";
    //here
    Statement stmtAlleAbrufen = con.createStatement();
    ResultSet athleten_rs = stmtAlleAbrufen.executeQuery(abrufenAthleten);
    while (athleten_rs.next()) {
        long id = athleten_rs.getInt(1);
        String name = athleten_rs.getString(2);
        LinkedList<Leistung> alleLeistungen = alleAbrufen((int) (id)); //after this line the ResultSet gets closed
        alleAthleten.add(new Athlet(id, name, alleLeistungen));
    }
    return alleAthleten;
}

public LinkedList<Leistung> alleAbrufen(int athlet_id) throws SQLException {
    LinkedList<Leistung> alleLeistungen = new LinkedList<Leistung>();
    //here again, but since you need to use parameters in your query
    //use PreparedStatement instead
    //note that I commented the current query
    //String selectLeistungen = "SELECT * FROM Leistung WHERE athlet_id="+athlet_id;
    //this is how a query with parameters look like
    String selectLeistungen = "SELECT * FROM Leistung WHERE athlet_id=?";
    //the connection prepares the statement
    PreparedStatement pstmt = con.prepareStatement(selectLeistungen);
    //then we pass the parameters
    pstmt.setInt(1, athlet_id);
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
        long id = rs.getInt(1); 
        String bezeichnung = rs.getString(2);
        String datum = rs.getString(3);
        double geschwindigkeit = rs.getDouble(4);
        boolean selectedForSlopeFaktor = rs.getBoolean(5);
        int strecke_id = rs.getInt(7);
        long longAthlet_id = (long) athlet_id;
        Leistung leistung = new Leistung(strecke_id, longAthlet_id, bezeichnung, datum, geschwindigkeit);
        leistung.setLeistungID(id);
        leistung.setIsUsedForSlopeFaktor(selectedForSlopeFaktor);
        alleLeistungen.add(leistung);
    }
    return alleLeistungen;
}