ResultSet rs_Tbl_CONTROL_SYNCHRONISM = con.query("Select * From DB_EGLISE.Tbl_CONTROL_synchronism;");

JsonObject jsonResponse = new JsonObject(); 
JsonArray data = new JsonArray();
while(rs_Tbl_CONTROL_SYNCHRONISM.next() ) {
JsonArray row = new JsonArray();
row.add(new JsonPrimitive(rs_Tbl_CONTROL_SYNCHRONISM.getString("columnName1")));
row.add(new JsonPrimitive(rs_Tbl_CONTROL_SYNCHRONISM.getString("columnName2")));
row.add(new JsonPrimitive(rs_Tbl_CONTROL_SYNCHRONISM.getString("columnName3")));

data.add(row);
}
jsonResponse.add("aaData", data);