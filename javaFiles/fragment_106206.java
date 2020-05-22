String sql = "INSERT INTO PROGETTO.LIBRO (ISBN, DISPONIBILITA, TITOLO, "
        + "CASA_EDITRICE, CODICE_AUTORE, GENERE, PREZZO)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

try (PreparedStatement stmt = conn.createStatement()) {

    NumberFormat numberFormat = NumberFormat.getInstance(Locale.ITALY);
    String ISBN = txt_isbn.getText();
    String DISPONIBILITA = txt_disp.getText();
    String TITOLO = txt_titolo.getText();
    String CASA_EDITRICE = txt_casa.getText();
    String CODICE_AUTORE = txt_autore.getText();
    String GENERE = txt_genere.getText();
    BigDecimal PREZZO = new BigDecimal(
            numberFormat.parse(txt_prezzo.getText()).doubleValue())
           .setScale(2);
    stmt.setString(1, ISBN);
    stmt.setString(2, DISPONIBILITA);
    stmt.setString(3, TITOLO);
    stmt.setString(4, CASA_EDITRICE);
    stmt.setString(5, CODICE_AUTORE);
    stmt.setString(6, GENERE);
    stmt.setBigDecimal(7, PREZZO);

    int updateCount = stmt.executeUpdate();

    JOptionPane.showMessageDialog(null, "SALVATO");
} catch(SQLException | HeadlessException e) {
    JOptionPane.showMessageDialog(null, e);
}