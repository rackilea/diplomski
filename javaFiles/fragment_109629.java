private void writeTableData() {
Database database = new Database(
    "database",
    "localhost:3306",
    "root",
    " "
);

try {
    ResultSet resultOvereenkomst = database.executeQuery("SELECT * FROM testDatabase.Overeenkomst LEFT JOIN testDatabase.Gevonden ON Gevonden.idGevonden = Overeenkomst.GevondenID  WHERE Gesloten = 1;");

    while (resultOvereenkomst.next()) {
        Bagage bagage = new Bagage();
        bagage.setId(resultOvereenkomst.getInt("OvereenkomstID"));
        bagage.setDatum(resultOvereenkomst.getString("Datum"));
        bagage.setLabelNummer(checkGevonden.getInt("Labelnummer"));
        bagage.setBagageType(checkGevonden.getString("BagageType")); 
        geslotenData.add(bagage);
    }

} catch (SQLException ex) {

}
}