String sql = "INSERT INTO Facture" +
            " (Date_Achat, Remise, Acompte, Mode_De_Paiement, N°Client)" +
            " VALUES (?, ?, ?, ?, ?)";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setDate  (1, java.sql.Date.valueOf(LocalDate.now()));
    stmt.setInt   (2, remise);
    stmt.setInt   (3, acompte);
    stmt.setString(4, modeDePaiement);
    stmt.setInt   (5, noClient);
    stmt.executeUpdate();
}