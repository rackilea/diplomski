public static void setupID_TITLE_ComboBox(JComboBox jComboBox, String tableName) throws SQLException {

    String query = "SELECT ID,TITRE FROM " + tableName + ";";
    ResultSet myJComboResultSet = SQLTools.ExecuteQuery(query);

    HashMap myMap = new HashMap();
    while (myJComboResultSet.next()) {  
        myMap.put(myJComboResultSet.getObject("TITRE"), myJComboResultSet.getObject("ID"));
    }

    jComboBox.setModel(new MapComboBoxModel(myMap) {

        @Override
        public Object getValue(Object selectedItem) {
            return map_data.get(selectedItem); //To change body of generated methods, choose Tools | Templates.
        }

    });


}