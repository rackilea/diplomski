public static ObservableList<List<String>> getUnits() {

    final ObservableList<List<String>> data = FXCollections.observableArrayList();
    if (openConnection()) {
        try {
            rs = st.executeQuery("SELECT * FROM units");
            while (rs.next()) {
                List<String> unit = new ArrayList<>();
                unit.add(rs.getString("id_unit"));
                unit.add(rs.getString("short_name"));
                unit.add(rs.getString("name"));
                data.add(unit);
            }
        } catch (Exception ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    closeConnection();
    return data;
}